package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.TreatedEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TreatedService extends CrudService<TreatedEntity, Integer> {
    @Override
    TreatedEntity create(TreatedEntity entity);

    @Override
    Optional<TreatedEntity> readById(Integer integer);

    @Override
    Page<TreatedEntity> readAll(Pageable pageable);

    @Override
    void update(TreatedEntity newEntity);

    @Override
    void delete(Integer integer);
}
