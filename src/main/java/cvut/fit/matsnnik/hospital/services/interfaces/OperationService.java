package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.OperationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OperationService extends CrudService<OperationEntity, Integer> {
    @Override
    OperationEntity create(OperationEntity entity);

    @Override
    Optional<OperationEntity> readById(Integer integer);

    @Override
    Page<OperationEntity> readAll(Pageable pageable);

    @Override
    void update(OperationEntity newEntity);

    @Override
    void delete(Integer integer);
}
