package cvut.fit.matsnnik.hospital.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorLoginDTO;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorModel;
import cvut.fit.matsnnik.hospital.api.dtos.PatientDTO;
import cvut.fit.matsnnik.hospital.api.dtos.PatientLoginDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    PatientService patientService;
    protected PatientEntity patientEntity;
    protected PatientEntity updatedPatientEntity;
    protected PatientDTO patientDTO;
    protected PatientDTO updatedPatientDTO;
    protected PatientLoginDTO patientLoginDTO;

    @BeforeEach
    public void initialise() {
        this.patientEntity = new PatientEntity(1,
                "email@email.com", "name", "surname",22, "password");
        this.updatedPatientEntity = new PatientEntity(1,
                "email@email.com", "updated", "surname",22, "password");
        this.patientDTO = patientEntity.toModel();
        this.updatedPatientDTO = updatedPatientEntity.toModel();
        this.patientLoginDTO = new PatientLoginDTO(patientDTO.getEmail(), patientDTO.getPassword());
        this.objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("register patient controller test")
    public void registerPatientTest() throws Exception {
        when(patientService.register(patientEntity.getpid(),
                patientEntity.getEmail(),
                patientEntity.getName(),
                patientEntity.getSurname(),
                patientEntity.getAge(),
                patientEntity.getPassword()))
                .thenReturn(patientEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/patients/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(patientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("login Patient controller test")
    public void loginPatientTest() throws Exception {
        when(patientService.login(patientEntity.getEmail(),patientEntity.getPassword()))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/patients/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(patientLoginDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("get by pid Patient controller test")
    public void getByIDTest() throws Exception {
        when(patientService.findByPid(patientEntity.getpid()))
                .thenReturn(patientEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/patients/{pid}", patientEntity.getpid())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(patientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pid", is(patientDTO.getPid())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(patientDTO.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname", is(patientDTO.getSurname())));
    }
    @Test
    @DisplayName("get by email Patient controller test")
    public void getByEmailTest() throws Exception {
        when(patientService.findByEmail(patientEntity.getEmail()))
                .thenReturn(patientEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/patients/email/{email}", patientEntity.getEmail())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(patientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pid", is(patientDTO.getPid())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(patientDTO.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname", is(patientDTO.getSurname())));
    }

    @Test
    @DisplayName("update Patient controller test")
    public void updatePatientTest() throws Exception {
        when(patientService.updatePatient(updatedPatientEntity, patientEntity.getpid())).thenReturn(updatedPatientEntity);
        mockMvc.perform(MockMvcRequestBuilders.put("/patients/{pid}", patientEntity.getpid())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(updatedPatientDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("create empty doctor controller test")
    public void createEmptyPatientTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/patients/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
