package cvut.fit.matsnnik.hospital.services.RequestSessionService;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.repositories.RequestSessionRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import cvut.fit.matsnnik.hospital.services.interfaces.RequestSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Time;

@SpringBootTest
public class BaseTest {
    @Autowired
    RequestSessionService requestSessionService;

    @MockBean
    RequestSessionRepository requestSessionRepository;

    RequestSessionEntity entity;


    @BeforeEach
    void setUp(){
        this.entity = new RequestSessionEntity(
                1,
                1,
                new Time(11111),
                new Time(22222),
                "name",
                0);
    }
}
