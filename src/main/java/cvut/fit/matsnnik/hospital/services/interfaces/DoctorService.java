package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
@Service
@Component
public interface DoctorService extends CrudService<DoctorEntity, Integer> {
    @Override
    DoctorEntity create(DoctorEntity entity);

    @Override
    Optional<DoctorEntity> readById(Integer integer);

    @Override
    Page<DoctorEntity> readAll(Pageable pageable);

    @Override
    void update(DoctorEntity newEntity);

    @Override
    void delete(Integer integer);
    DoctorEntity findByDid(int did);

    DoctorEntity updateDoctor(DoctorEntity doctorEntity, Integer did);
    DoctorEntity registerDoctor(Integer did, String name, String surname, String dType, String password);
    boolean loginDoctor(int did, String password);

    Iterable<DoctorEntity> getAll();
}
