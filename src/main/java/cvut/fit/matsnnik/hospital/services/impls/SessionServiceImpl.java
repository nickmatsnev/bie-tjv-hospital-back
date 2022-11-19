package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.api.dtos.SessionModel;
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
import javax.persistence.EntityNotFoundException;
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
            System.out.println("function create in service of session");
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
    public Collection<SessionModel> findAllByPatient(Integer id) {
        if (sessionRepository.findSessionEntitiesByPatient(patientRepository.findPatientEntityByPid(id)) == null)
            throw new EntityNotFoundException("No patient with id " + id.toString() + " exists");
        List<SessionModel> res = new ArrayList<>();
        if (sessionRepository.findSessionEntitiesByPatient(patientRepository.findPatientEntityByPid(id)) != null)
            for (var event: sessionRepository.findSessionEntitiesByPatient(patientRepository.findPatientEntityByPid(id)))
                res.add(SessionEntity.toModel(event));

        return res;
    }

    @Override
    public Collection<SessionModel> findAllByDoctor(Integer id) {
        if (sessionRepository.findSessionEntitiesByDoctor(doctorRepository.findDoctorEntityByDid(id)) == null)
            throw new EntityNotFoundException("No doctor with id " + id.toString() + " exists");
        List<SessionModel> res = new ArrayList<>();
        if (sessionRepository.findSessionEntitiesByDoctor(doctorRepository.findDoctorEntityByDid(id)) != null)
            for (var event: sessionRepository.findSessionEntitiesByDoctor(doctorRepository.findDoctorEntityByDid(id)))
                res.add(SessionEntity.toModel(event));

        return res;
    }

    private SessionEntity findOrThrow(Integer oid){
        SessionEntity optionalSession = sessionRepository.findSessionEntityByOid(oid);
        if (optionalSession == null) { throw new IllegalArgumentException(); }
        return optionalSession;
    }
}
