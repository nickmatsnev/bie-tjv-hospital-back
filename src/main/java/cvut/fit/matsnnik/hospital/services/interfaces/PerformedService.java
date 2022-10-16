package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.PerformsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PerformedService extends CrudService<PerformsEntity, Integer> {
    @Override
    PerformsEntity create(PerformsEntity entity);

    @Override
    Optional<PerformsEntity> readById(Integer integer);

    @Override
    Page<PerformsEntity> readAll(Pageable pageable);

    @Override
    void update(PerformsEntity newEntity);

    @Override
    void delete(Integer integer);
}
