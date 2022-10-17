package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PatientService extends CrudService<PatientEntity, Integer> {
    @Override
    PatientEntity create(PatientEntity entity);

    @Override
    Optional<PatientEntity> readById(Integer integer);

    @Override
    Page<PatientEntity> readAll(Pageable pageable);

    @Override
    void update(PatientEntity newEntity);

    @Override
    void delete(Integer integer);
}
