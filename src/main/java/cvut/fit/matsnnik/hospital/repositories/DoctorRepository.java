package cvut.fit.matsnnik.hospital.repositories;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    DoctorEntity findDoctorEntityByDid(int did);

    List<DoctorEntity> findAll();
}
