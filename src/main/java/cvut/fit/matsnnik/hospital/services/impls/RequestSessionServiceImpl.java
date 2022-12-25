package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.api.dtos.RequestModel;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.repositories.RequestSessionRepository;
import cvut.fit.matsnnik.hospital.repositories.SessionRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.RequestSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RequestSessionServiceImpl implements RequestSessionService {
    private RequestSessionRepository requestSessionRepository;
    private final SessionRepository sessionRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    @Autowired
    public RequestSessionServiceImpl(RequestSessionRepository requestSessionRepository,
                                     SessionRepository sessionRepository,
                                     PatientRepository patientRepository,
                                     DoctorRepository doctorRepository){
        this.requestSessionRepository = requestSessionRepository;
        this.sessionRepository = sessionRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public RequestSessionEntity create(RequestSessionEntity entity) {
        requestSessionRepository.saveAndFlush(entity);
        return entity;
    }

    @Override
    public Optional<RequestSessionEntity> readById(Integer integer) {
        Optional<RequestSessionEntity> optRequest = requestSessionRepository.findByRequestId(integer);

        if (optRequest.get() == null) { throw new IllegalArgumentException(); }
        return optRequest;
    }

    @Override
    public Page<RequestSessionEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(RequestSessionEntity newEntity) {
        requestSessionRepository.saveAndFlush(newEntity);

    }

    @Override
    public void delete(Integer integer) {
        requestSessionRepository.deleteById(integer);
    }
    @Override
    public RequestSessionEntity getById(Integer requestId){
        return findOrThrow(requestId);
    }
    @Override
    public List<RequestSessionEntity> getPendingRequestsByDoctorId(Integer doctorId){
        return requestSessionRepository.findRequestSessionEntitiesByStatusAndDoctorId(0, doctorId);
    }
    @Override
    public List<RequestSessionEntity> getRejectedRequestsByDoctorId(Integer doctorId){
        return requestSessionRepository.findRequestSessionEntitiesByStatusAndDoctorId(2, doctorId);
    }
    @Override
    public List<RequestSessionEntity> getPendingRequestsByPatientId(Integer doctorId){
        return requestSessionRepository.findRequestSessionEntitiesByStatusAndPatientId(0, doctorId);
    }
    @Override
    public List<RequestSessionEntity> getRejectedRequestsByPatientId(Integer doctorId){
        return requestSessionRepository.findRequestSessionEntitiesByStatusAndPatientId(2, doctorId);
    }
    @Override
    public SessionEntity accept(String sessionName, Integer patientId, Integer doctorId){
        RequestSessionEntity requestSession = requestSessionRepository.getBySessionNameAndDoctorIdAndPatientId(sessionName, doctorId, patientId);
        requestSession.setStatus(1);
        SessionEntity sessionEntity = new SessionEntity(requestSession.getStartTime(),
                requestSession.getEndTime(),
                requestSession.getSessionName(),
                doctorRepository.findDoctorEntityByDid(requestSession.getDoctorId()),
                patientRepository.findPatientEntityByPid(requestSession.getPatientId())
        );
        requestSessionRepository.saveAndFlush(requestSession);
        return sessionRepository.saveAndFlush(sessionEntity);
    }
    @Override
    public RequestSessionEntity reject(String sessionName, Integer patientId, Integer doctorId){
        RequestSessionEntity requestSession = requestSessionRepository.getBySessionNameAndDoctorIdAndPatientId(sessionName, doctorId, patientId);
        requestSession.setStatus(2);
        return requestSessionRepository.saveAndFlush(requestSession);
    }
    @Override
    public RequestSessionEntity createByModel(RequestModel requestModel){
        return requestSessionRepository.saveAndFlush(requestModel.toEntity());
    }
    @Override
    public RequestSessionEntity getEntityByNameAndDoctorAndPatient(String sessionName, Integer patientId, Integer doctorId){
        return requestSessionRepository.getBySessionNameAndDoctorIdAndPatientId(sessionName, patientId, doctorId);
    }

    private RequestSessionEntity findOrThrow(Integer id){
        Optional<RequestSessionEntity> optRequest = requestSessionRepository.findByRequestId(id);

        if (optRequest.get() == null) { throw new IllegalArgumentException(); }
        return optRequest.get();
    }
}
