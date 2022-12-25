package cvut.fit.matsnnik.hospital.services.DoctorService;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DoctorServiceTest extends BaseTest{

    @Test
    @DisplayName("Create doctor test")
    void createTest(){
        doctorService.create(this.doctor);
        Mockito.verify(doctorRepository).save(this.doctor);
        assertThat(this.doctor.getName()).isNotNull();
    }

    @Test
    @DisplayName("Read doctor test")
    void readTest(){
        DoctorEntity savedDoctor = doctorService.create(this.doctor);
        Mockito.verify(doctorRepository).save(this.doctor);
        assertEquals(savedDoctor.getSurname(), this.doctor.getSurname());
    }

    @Test
    @DisplayName("Update doctor test")
    void updateTest(){
        DoctorEntity newDoctor = this.doctor;
        newDoctor.setName("Updated");
        doctorService.update(newDoctor);
        Mockito.verify(doctorRepository).save(newDoctor);
        assertThat(this.doctor.getName()).isEqualTo("Updated");
    }

    @Test
    @DisplayName("Delete doctor test")
    void deleteTest(){
        doctorService.delete(this.doctor.getDid());
        Mockito.verify(doctorRepository).deleteById(this.doctor.getDid());
    }
}
