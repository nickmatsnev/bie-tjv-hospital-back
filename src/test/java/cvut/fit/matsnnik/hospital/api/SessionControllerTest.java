package cvut.fit.matsnnik.hospital.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fit.matsnnik.hospital.api.dtos.*;
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
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
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

@WebMvcTest(SessionController.class)
public class SessionControllerTest {
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
    private DoctorModel doctorModel;
    private PatientDTO patientModel;
    private SessionEntity session;

    private SessionDTO sessionDTO;
    private SessionActualDTO sessionActualDTO;

    private SessionModel sessionModel;

    private List<SessionEntity> sessions;
    private List<SessionDTO> sessionDTOS;
    private List<SessionActualDTO> sessionActualDTOS;

    private List<SessionModel> sessionModels;

    @BeforeEach
    public void initialise() {
        this.doctor = new DoctorEntity(1,
                "nameD", "surnameD", "dtype", "password");
        this.doctorModel = new DoctorModel(1,
                "nameD", "surnameD", "dtype", "password");
        this.patient = new PatientEntity(1,
                "email@email.com", "nameP", "surnameP",22, "password");
        this.patientModel = new PatientDTO(1,
                "email@email.com", "nameP", "surnameP",22, "password");

        this.session = new SessionEntity(
                new Time(11111),
                new Time(22222),
                "nameS",
                doctor,
                patient
        );

        this.sessionDTO = new SessionDTO("nameS", 1111L,2222L,doctorModel,patientModel);

        this.sessionActualDTO = new SessionActualDTO("1111", "2222", "nameS", 1L, "nameP SurnameP");

        this.sessionModel = new SessionModel(
                1111L,
                2222L,
                "nameS",
                1,1
        );

        this.objectMapper = new ObjectMapper();
        this.sessions = new ArrayList<>();
        this.sessions.add(session);

        this.sessionActualDTOS = new ArrayList<>();
        this.sessionActualDTOS.add(sessionActualDTO);

        this.sessionDTOS = new ArrayList<>();
        this.sessionDTOS.add(sessionDTO);

        this.sessionModels = new ArrayList<>();
        this.sessionModels.add(sessionModel);
    }
    @Test
    @DisplayName("get by id session controller test")
    public void getByIDTest() throws Exception {
        when(sessionService.findByOid(session.getOid()))
                .thenReturn(session);

        mockMvc.perform(MockMvcRequestBuilders.get("/sessions/session/{oid}", session.getOid()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(session.getName())));
    }

    @Test
    @DisplayName("get by patient id session controller test")
    public void getByPatientIDTest() throws Exception {
        when(sessionService.findAllByPatient(session.getPatient().getpid()))
                .thenReturn(sessionModels);
        when(patientService.findByPid(patient.getpid())).thenReturn(patient);

        mockMvc.perform(MockMvcRequestBuilders.get("/sessions/patient/{id}", patient.getpid()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("get by doctor id session controller test")
    public void getByDoctorIDTest() throws Exception {
        when(sessionService.findAllByDoctor(session.getDoctor().getDid()))
                .thenReturn(sessionModels);
        when(doctorService.findByDid(doctor.getDid())).thenReturn(doctor);

        mockMvc.perform(MockMvcRequestBuilders.get("/sessions/doctor/{id}", doctor.getDid()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
