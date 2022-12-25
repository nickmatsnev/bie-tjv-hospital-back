package cvut.fit.matsnnik.hospital.services.DoctorService;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BaseTest {
    @Autowired
    protected DoctorService doctorService;

    @MockBean
    protected DoctorRepository doctorRepository;

    protected DoctorEntity doctor;


    @BeforeEach
    void setUp(){
        doctor = new DoctorEntity(111111,
                "testName",
                "testSurname",
                "testType",
                "testPassword");
    }
}
