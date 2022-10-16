package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository  extends JpaRepository<OperationEntity, Integer> {
}
