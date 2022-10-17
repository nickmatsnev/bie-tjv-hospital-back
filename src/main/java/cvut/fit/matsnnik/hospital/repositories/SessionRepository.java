package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {

}
