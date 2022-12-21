package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestSessionRepository extends JpaRepository<RequestSessionEntity, Integer> {

     Optional<RequestSessionEntity> findByRequestId(Integer requestId);

     Iterable<RequestSessionEntity> findRequestSessionEntitiesByStatusAndDoctorId(Integer status, Integer doctorId);

     Iterable<RequestSessionEntity> findRequestSessionEntitiesByStatusAndPatientId(Integer status, Integer patientId);


}
