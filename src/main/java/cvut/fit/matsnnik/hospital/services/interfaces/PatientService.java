package cvut.fit.matsnnik.hospital.services.interfaces;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public interface PatientService extends CrudService<PatientEntity, Integer> {
    @Override
    PatientEntity create(PatientEntity entity);

    @Override
    Optional<PatientEntity> readById(Integer integer);

    @Override
    Page<PatientEntity> readAll(Pageable pageable);

    @Override
    void update(PatientEntity newEntity);

    @Override
    void delete(Integer integer);

    PatientEntity findByEmail(String email);
    PatientEntity findByPid(int pid);

    PatientEntity updatePatient(PatientEntity patientEntity, int pid);
    PatientEntity register(Integer pid, String email, String name, String surname, Integer age, String password);

    boolean login(String email, String password);

    List<PatientEntity> getAll();

    PatientEntity findByNameAndSurname(String name, String surname);
}
