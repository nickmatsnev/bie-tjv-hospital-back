package cvut.fit.matsnnik.hospital.services.PatientService;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BaseTest {
    @Autowired
    PatientService patientService;

    @MockBean
    PatientRepository patientRepository;

    PatientEntity patient;


    @BeforeEach
    void setUp(){
        this.patient = new PatientEntity(222222,
                "testEmail",
                "testName",
                "testSurname",
                22,
                "testPassword");
    }
}
