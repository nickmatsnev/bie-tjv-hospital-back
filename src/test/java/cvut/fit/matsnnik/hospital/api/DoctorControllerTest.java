package cvut.fit.matsnnik.hospital.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorLoginDTO;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorModel;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    DoctorService doctorService;
    protected DoctorEntity doctorEntity;
    protected DoctorEntity doctorEntityUpdated;
    protected DoctorModel doctorModel;
    protected DoctorModel doctorModelUpdated;
    protected DoctorLoginDTO doctorLoginDTO;

    @BeforeEach
    public void initialise() {
        this.doctorEntity = new DoctorEntity(1,
                "name", "surname", "dtype", "password");
        this.doctorEntityUpdated = new DoctorEntity(1,
                "name", "updated", "dtype", "password");
        this.doctorModel = doctorEntity.toModel();
        this.doctorModelUpdated = doctorEntityUpdated.toModel();
        this.doctorLoginDTO = new DoctorLoginDTO(doctorModel.getDid(), doctorModel.getPassword());
        this.objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("register doctor controller test")
    public void registerDoctorTest() throws Exception {
        when(doctorService.registerDoctor(doctorEntity.getDid(),doctorEntity.getName(),doctorEntity.getSurname(),doctorEntity.getdType(),doctorEntity.getPassword()))
                .thenReturn(doctorEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/doctors/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(doctorModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("login doctor controller test")
    public void loginDoctorTest() throws Exception {
        when(doctorService.loginDoctor(doctorEntity.getDid(),doctorEntity.getPassword()))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/doctors/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(doctorLoginDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("get by did doctor controller test")
    public void getByIDTest() throws Exception {
        when(doctorService.findByDid(doctorEntity.getDid()))
                .thenReturn(doctorEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/doctors/{did}", doctorEntity.getDid())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(doctorModel)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.did", is(doctorModel.getDid())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(doctorModel.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dType", is(doctorModel.getdType())));
    }

    @Test
    @DisplayName("update doctor controller test")
    public void updateUserTest() throws Exception {
        when(doctorService.updateDoctor(doctorEntityUpdated, doctorEntity.getDid())).thenReturn(doctorEntityUpdated);
        mockMvc.perform(MockMvcRequestBuilders.put("/doctors/{did}", doctorEntity.getDid())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(doctorModelUpdated)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("create empty doctor controller test")
    public void createEmptyUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/doctors/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
