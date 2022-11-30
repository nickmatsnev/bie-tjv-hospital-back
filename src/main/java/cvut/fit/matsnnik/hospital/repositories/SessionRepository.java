package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {
    SessionEntity findSessionEntityByOid(int oid);

    SessionEntity findSessionEntityByNameAndDoctor(String name, DoctorEntity doctor);

    Iterable<SessionEntity> findSessionEntitiesByPatient(PatientEntity patient);
    Iterable<SessionEntity> findSessionEntitiesByDoctor(DoctorEntity doctor);
}
