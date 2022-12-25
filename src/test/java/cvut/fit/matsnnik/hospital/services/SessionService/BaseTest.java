package cvut.fit.matsnnik.hospital.services.SessionService;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.repositories.RequestSessionRepository;
import cvut.fit.matsnnik.hospital.repositories.SessionRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.RequestSessionService;
import cvut.fit.matsnnik.hospital.services.interfaces.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Time;

public class BaseTest {
    @Autowired
    protected SessionService sessionService;

    @MockBean
    protected SessionRepository sessionRepository;

    protected SessionEntity entity;

    protected DoctorEntity doctor;
    protected PatientEntity patient;


    @BeforeEach
    void setUp(){

        doctor = new DoctorEntity(111111,
                "testName",
                "testSurname",
                "testType",
                "testPassword");
        patient = new PatientEntity(222222,
                "testEmail",
                "testName",
                "testSurname",
                22,
                "testPassword");
        this.entity = new SessionEntity(
                new Time(11111),
                new Time(22222),
                "SessionTestName",
                doctor,
                patient
                );
    }
}
