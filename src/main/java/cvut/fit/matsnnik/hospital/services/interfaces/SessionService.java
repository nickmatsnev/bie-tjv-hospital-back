package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

public interface SessionService extends CrudService<SessionEntity, Integer> {
    @Override
    SessionEntity create(SessionEntity entity);

    @Override
    Optional<SessionEntity> readById(Integer integer);

    @Override
    Page<SessionEntity> readAll(Pageable pageable);

    @Override
    void update(SessionEntity newEntity);

    @Override
    void delete(Integer integer);

    SessionEntity updateSession(SessionEntity updatedSession, Integer oid);

    SessionEntity findByOid(Integer oid);

    Set<PatientEntity> getPatientsById(Integer oid);
    Set<DoctorEntity> getDoctorsById(Integer oid);
}
