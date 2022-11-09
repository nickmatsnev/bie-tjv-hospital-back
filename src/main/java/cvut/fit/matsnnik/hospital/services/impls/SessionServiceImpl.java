package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.repositories.SessionRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository,
                              PatientRepository patientRepository,
                              DoctorRepository doctorRepository) {
        this.sessionRepository = sessionRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
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
        else {
            SessionEntity existingSession = sessionRepository.findSessionEntityByOid(oid);
            existingSession.setName(updatedSession.getName());
            existingSession.setActualStart(updatedSession.getActualStart());
            existingSession.setActualEnd(updatedSession.getActualEnd());
            existingSession.setDoctor(updatedSession.getDoctor());
            existingSession.setPatient(updatedSession.getPatient());
            existingSession.setStatus(updatedSession.getStatus());
            return sessionRepository.saveAndFlush(existingSession);
        }
    }

    @Override
    public PatientEntity getPatientById(Integer oid) {
        SessionEntity session = findOrThrow(oid);
        return session.getPatient();
    }

    @Override
    public DoctorEntity getDoctorById(Integer oid) {
        SessionEntity session = findOrThrow(oid);
        return session.getDoctor();
    }

    @Override
    public SessionEntity findByOid(Integer oid) {
        return findOrThrow(oid);
    }

    @Override
    public List<SessionEntity> findAllByPatient(Integer id) {
        PatientEntity patient = patientRepository.findPatientEntityByPid(id);
        return (List<SessionEntity>) sessionRepository.findSessionEntitiesByPatient(patient);
    }

    @Override
    public List<SessionEntity> findAllByDoctor(Integer id) {
        DoctorEntity doctor = doctorRepository.findDoctorEntityByDid(id);
        return (List<SessionEntity>) sessionRepository.findSessionEntitiesByDoctor(doctor);
    }

    private SessionEntity findOrThrow(Integer oid){
        SessionEntity optionalSession = sessionRepository.findSessionEntityByOid(oid);
        if (optionalSession == null) { throw new IllegalArgumentException(); }
        return optionalSession;
    }
}
