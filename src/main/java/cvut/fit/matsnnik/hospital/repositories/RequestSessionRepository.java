package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequestSessionRepository extends JpaRepository<RequestSessionEntity, Integer> {

     Optional<RequestSessionEntity> findByRequestId(Integer requestId);

     List<RequestSessionEntity> findRequestSessionEntitiesByStatusAndDoctorId(Integer status, Integer doctorId);

     List<RequestSessionEntity> findRequestSessionEntitiesByStatusAndPatientId(Integer status, Integer patientId);

     RequestSessionEntity getBySessionNameAndDoctorIdAndPatientId(String sessionName,  Integer doctorId,Integer patientId);

}
