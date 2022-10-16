package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.PerformsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformsRepository extends JpaRepository<PerformsEntity, Integer> {
}
