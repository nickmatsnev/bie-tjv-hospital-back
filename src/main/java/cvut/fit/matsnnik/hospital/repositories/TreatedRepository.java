package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.TreatedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatedRepository extends JpaRepository<TreatedEntity, Integer> {
}
