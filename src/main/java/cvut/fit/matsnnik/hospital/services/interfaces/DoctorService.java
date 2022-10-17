package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DoctorService extends CrudService<DoctorEntity, Integer> {
    @Override
    DoctorEntity create(DoctorEntity entity);

    @Override
    Optional<DoctorEntity> readById(Integer integer);

    @Override
    Page<DoctorEntity> readAll(Pageable pageable);

    @Override
    void update(DoctorEntity newEntity);

    @Override
    void delete(Integer integer);
    DoctorEntity findByDid(int did);
    DoctorEntity registerDoctor(Integer did, String name, String surname, String dType, String password);
    boolean loginDoctor(int did, String password);
}
