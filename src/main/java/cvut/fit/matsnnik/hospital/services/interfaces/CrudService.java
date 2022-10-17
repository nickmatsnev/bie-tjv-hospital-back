package cvut.fit.matsnnik.hospital.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CrudService<T,ID> {
    T create(T entity);

    Optional<T> readById(ID id);

    Page<T> readAll(Pageable pageable);

    void update(T newEntity);

    void delete(ID id);
}
