package cvut.fit.matsnnik.hospital.services.PatientService;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientServiceTest extends BaseTest{

    @Test
    @DisplayName("Create patient test")
    void createTest(){
        patientService.create(this.patient);
        Mockito.verify(patientRepository).save(this.patient);
        assertThat(this.patient.getName()).isNotNull();
    }

    @Test
    @DisplayName("Read patient test")
    void readTest(){
        PatientEntity savedPatient = patientService.create(this.patient);
        Mockito.verify(patientRepository).save(this.patient);
        assertEquals(savedPatient.getSurname(), this.patient.getSurname());
    }

    @Test
    @DisplayName("Update patient test")
    void updateTest(){
        PatientEntity newPatient = this.patient;
        newPatient.setSurname("Updated");
        patientService.update(newPatient);
        Mockito.verify(patientRepository).saveAndFlush(newPatient);
        assertThat(this.patient.getSurname()).isEqualTo("Updated");
    }

    @Test
    @DisplayName("Delete patient test")
    void deleteTest(){
        patientService.delete(this.patient.getpid());
        Mockito.verify(patientRepository).deleteById(this.patient.getpid());
    }

}
