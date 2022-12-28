package cvut.fit.matsnnik.hospital.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fit.matsnnik.hospital.api.dtos.PatientLoginDTO;
import cvut.fit.matsnnik.hospital.api.dtos.RequestModel;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import cvut.fit.matsnnik.hospital.services.interfaces.RequestSessionService;
import cvut.fit.matsnnik.hospital.services.interfaces.SessionService;
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

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
@WebMvcTest(RequestSessionController.class)
public class RequestSessionControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    RequestSessionService requestSessionService;

    @MockBean
    SessionService sessionService;

    @MockBean
    DoctorService doctorService;

    @MockBean
    PatientService patientService;


    private PatientEntity patient;

    private DoctorEntity doctor;

    private RequestSessionEntity requestSessionEntity;

    private RequestModel requestModel;

    private SessionEntity session;

    private List<RequestSessionEntity> requests;
    @BeforeEach
    public void initialise() {
        this.doctor = new DoctorEntity(1,
                "nameD", "surnameD", "dtype", "password");
        this.patient = new PatientEntity(1,
                "email@email.com", "nameP", "surnameP",22, "password");
        this.requestSessionEntity = new RequestSessionEntity(1,1,
                1,
                new Time(11111),
                new Time(22222),
                "testName",
                0);
        this.requestModel = new RequestModel(1,
                1,
                new Time(11111),
                new Time(22222),
                "testName");
        this.session = new SessionEntity(
                new Time(11111),
                new Time(22222),
                "nameS",
                doctor,
                patient
                );

        this.objectMapper = new ObjectMapper();
        this.requests = new ArrayList<>();
        this.requests.add(requestSessionEntity);
    }

    @Test
    @DisplayName("create request to a session controller test")
    public void create() throws Exception {
        when(requestSessionService.createByModel(this.requestModel))
                .thenReturn(this.requestSessionEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/requests/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("get by id request controller test")
    public void getByIDTest() throws Exception {
        when(requestSessionService.getById(requestSessionEntity.getRequestId()))
                .thenReturn(requestSessionEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/{id}", requestSessionEntity.getRequestId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.sessionName", is(requestModel.getSessionName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.doctorId", is(requestModel.getDoctorId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.patientId", is(requestModel.getPatientId())));
    }

    @Test
    @DisplayName("get by doctor id pending requests controller test")
    public void getPendingRequestsByDoctor() throws Exception {
        when(requestSessionService.getPendingRequestsByDoctorId(requestSessionEntity.getDoctorId()))
                .thenReturn(requests);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/pending/doctor/{id}", requestSessionEntity.getDoctorId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("get by doctor id rejected requests controller test")
    public void getRejectedRequestsByDoctor() throws Exception {
        when(requestSessionService.getRejectedRequestsByDoctorId(requestSessionEntity.getDoctorId()))
                .thenReturn(requests);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/rejected/doctor/{id}", requestSessionEntity.getDoctorId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("get by patient id pending requests controller test")
    public void getPendingRequestsByPatient() throws Exception {
        when(requestSessionService.getPendingRequestsByDoctorId(requestSessionEntity.getDoctorId()))
                .thenReturn(requests);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/pending/patient/{id}", requestSessionEntity.getPatientId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("get by patient id rejected requests controller test")
    public void getRejectedRequestsByPatient() throws Exception {
        when(requestSessionService.getPendingRequestsByDoctorId(requestSessionEntity.getDoctorId()))
                .thenReturn(requests);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/rejected/patient/{id}", requestSessionEntity.getPatientId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("accept request controller test")
    public void acceptRequest() throws Exception {
        when(requestSessionService.getEntityByNameAndDoctorAndPatient(requestSessionEntity.getSessionName(),
                requestSessionEntity.getDoctorId(), requestSessionEntity.getPatientId()))
                .thenReturn(requestSessionEntity);
        when(doctorService.findByDid(requestSessionEntity.getDoctorId())).thenReturn(doctor);
        when(patientService.findByPid(requestSessionEntity.getPatientId())).thenReturn(patient);
        when(sessionService.create(session)).thenReturn(session);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/accept/{name}/{doctor}/{patient}", requestSessionEntity.getSessionName(), requestSessionEntity.getDoctorId(), requestSessionEntity.getPatientId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("reject request controller test")
    public void rejectRequest() throws Exception {
        when(requestSessionService.getEntityByNameAndDoctorAndPatient(requestSessionEntity.getSessionName(),
                requestSessionEntity.getDoctorId(), requestSessionEntity.getPatientId()))
                .thenReturn(requestSessionEntity);
        when(sessionService.create(session)).thenReturn(session);

        mockMvc.perform(MockMvcRequestBuilders.get("/requests/reject/{name}/{doctor}/{patient}", requestSessionEntity.getSessionName(), requestSessionEntity.getDoctorId(), requestSessionEntity.getPatientId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
