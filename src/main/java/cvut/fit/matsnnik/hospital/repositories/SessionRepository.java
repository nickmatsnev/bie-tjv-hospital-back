package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {
    SessionEntity findSessionEntityByOid(Integer oid);

}
