package cvut.fit.matsnnik.hospital.services.impls;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.repositories.DoctorRepository;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorEntity registerDoctor(Integer did, String name, String surname, String dType, String password) {
        DoctorEntity newUser = new DoctorEntity(did, name, surname, dType, password);

        return create(newUser);
    }

    public boolean loginDoctor(int did, String password){
        DoctorEntity doctorEntity = findOrThrow(did);
        return doctorEntity.getPassword().equals(password);
    }
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorEntity create(DoctorEntity entity) {
       DoctorEntity doctorEntity = doctorRepository.findDoctorEntityByDid(entity.getDid());
       System.out.println("all is good, because we are in service impl, " + entity.getName());
       if(doctorEntity != null){
           throw new EntityExistsException();
       }
       System.out.println("all is good, because we are in service impl, " + entity.getName());
       return doctorRepository.saveAndFlush(entity);
    }

    @Override
    public Optional<DoctorEntity> readById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Page<DoctorEntity> readAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(DoctorEntity newEntity) {
        doctorRepository.save(newEntity);
    }

    @Override
    public void delete(Integer integer) {
        doctorRepository.deleteById(integer);
    }
    @Override
    public DoctorEntity findByDid(int did) {
        return findOrThrow(did);
    }

    private DoctorEntity findOrThrow(int did) {
        DoctorEntity optionalDoctor = doctorRepository.findDoctorEntityByDid(did);
        if (optionalDoctor == null) {
            throw new IllegalArgumentException();
        }
        return optionalDoctor;
    }
    @Override
    public DoctorEntity updateDoctor(DoctorEntity doctorEntity, Integer did) {
        DoctorEntity optionalDoctor = doctorRepository.findDoctorEntityByDid(did);
        if (optionalDoctor == null) { throw new IllegalArgumentException(); }
        return doctorRepository.saveAndFlush(doctorEntity);
    }

    @Override
    public Iterable<DoctorEntity> getAll() {
        return doctorRepository.findAll();
    }
}
