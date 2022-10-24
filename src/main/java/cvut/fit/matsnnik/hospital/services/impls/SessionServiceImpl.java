package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.repositories.SessionRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;


    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public SessionEntity create(SessionEntity entity) {
        SessionEntity sessionEntity = sessionRepository.findSessionEntityByOid(entity.getOid());
        if(sessionEntity != null){
            throw new EntityExistsException();
        }
        return sessionRepository.saveAndFlush(entity);
    }

    @Override
    public Optional<SessionEntity> readById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Page<SessionEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(SessionEntity newEntity) {

    }

    @Override
    public void delete(Integer integer) {
    sessionRepository.deleteById(integer);
    }

    @Override
    public SessionEntity updateSession(SessionEntity updatedSession, Integer oid) {
        if(sessionRepository.findSessionEntityByOid(oid) == null) { throw new IllegalArgumentException(); }
        return sessionRepository.saveAndFlush(updatedSession);
    }

    @Override
    public Set<PatientEntity> getPatientsById(Integer oid) {
        SessionEntity session = findOrThrow(oid);
        return session.getPatients();
    }

    @Override
    public Set<DoctorEntity> getDoctorsById(Integer oid) {
        SessionEntity session = findOrThrow(oid);
        return session.getDoctors();
    }

    @Override
    public SessionEntity findByOid(Integer oid) {
        return findOrThrow(oid);
    }

    private SessionEntity findOrThrow(Integer oid){
        SessionEntity optionalSession = sessionRepository.findSessionEntityByOid(oid);
        if (optionalSession == null) { throw new IllegalArgumentException(); }
        return optionalSession;
    }

}
