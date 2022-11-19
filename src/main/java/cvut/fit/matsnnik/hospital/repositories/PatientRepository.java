package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
    PatientEntity findPatientEntityByEmail(String email);
    PatientEntity findPatientEntityByPid(int pid);

    PatientEntity findPatientEntityByNameAndSurname(String name, String surname);
    List<PatientEntity> findAll();
}
