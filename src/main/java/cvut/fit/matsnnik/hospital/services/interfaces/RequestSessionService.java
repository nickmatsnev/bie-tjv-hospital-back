package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.api.dtos.RequestModel;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RequestSessionService extends CrudService<RequestSessionEntity, Integer> {

    @Override
    RequestSessionEntity create(RequestSessionEntity entity);

    @Override
    Optional<RequestSessionEntity> readById(Integer integer);

    @Override
    Page<RequestSessionEntity> readAll(Pageable pageable);

    @Override
    void update(RequestSessionEntity newEntity);

    @Override
    void delete(Integer integer);

    public RequestSessionEntity getById(Integer requestId);
    public Iterable<RequestSessionEntity> getPendingRequestsByDoctorId(Integer doctorId);

    public Iterable<RequestSessionEntity> getRejectedRequestsByDoctorId(Integer doctorId);

    public Iterable<RequestSessionEntity> getPendingRequestsByPatientId(Integer doctorId);

    public Iterable<RequestSessionEntity> getRejectedRequestsByPatientId(Integer doctorId);

    public SessionEntity acceptById(Integer requestId);

    public RequestSessionEntity rejectById(Integer requestId);

    public RequestSessionEntity createByModel(RequestModel requestModel);

}
