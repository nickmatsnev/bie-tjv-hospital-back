package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.repositories.PatientRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientEntity create(PatientEntity entity) {
        System.out.println("session name: " + entity.getName());
        PatientEntity patientEntity = patientRepository.findPatientEntityByEmail(entity.getEmail());
        System.out.println("session name: " + entity.getName());
        if(patientEntity != null){
            throw new EntityExistsException();
        }
        System.out.println("session name: " + entity.getName());
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
        patientRepository.saveAndFlush(newEntity);
    }

    @Override
    public void delete(Integer integer) {
    patientRepository.deleteById(integer);
    }

    @Override
    public PatientEntity findByEmail(String email) {
        return findOrThrow(email);
    }

    @Override
    public PatientEntity findByPid(int pid){
        return findOrThrow(pid);
    }
    @Override
    public PatientEntity register(Integer pid, String email, String name, String surname, Integer age, String password) {
        PatientEntity newPatient = new PatientEntity(pid, email, name, surname, age, password);
        return create(newPatient);
    }

    @Override
    public boolean login(String email, String password) {
        PatientEntity patientEntity = findOrThrow(email);
        return patientEntity.getPassword().equals(password);
    }
    private PatientEntity findOrThrow(String email) {
        PatientEntity optionalPatient = patientRepository.findPatientEntityByEmail(email);
        if (optionalPatient == null) {
            throw new IllegalArgumentException();
        }
        return optionalPatient;
    }
    private PatientEntity findOrThrow(int pid) {
        PatientEntity optionalPatient = patientRepository.findPatientEntityByPid(pid);
        if (optionalPatient == null) {
            throw new IllegalArgumentException();
        }
        return optionalPatient;
    }

    @Override
    public PatientEntity updatePatient(PatientEntity patientEntity, int pid) {
        PatientEntity optionalPatient = patientRepository.findPatientEntityByPid(pid);
        if (optionalPatient == null) { throw new IllegalArgumentException(); }
        return patientRepository.saveAndFlush(patientEntity);
    }

    @Override
    public List<PatientEntity> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public PatientEntity findByNameAndSurname(String name, String surname) {
        System.out.println("patientServiceFindByNameAndSurname: ." + name + ". ." + surname + ".");
        PatientEntity patient = patientRepository.findPatientEntityByNameAndSurname(name, surname);
        System.out.println("patientServiceFindByNameAndSurname.patient.email: " + patient.getEmail());
        return patient;
    }
}
