package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityExistsException;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientEntity create(PatientEntity entity) {
        PatientEntity patientEntity = patientRepository.getReferenceById(entity.getpId());
        if(patientEntity != null){
            throw new EntityExistsException();
        }
        return patientRepository.saveAndFlush(entity);
    }

    @Override
    public Optional<PatientEntity> readById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Page<PatientEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(PatientEntity newEntity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
