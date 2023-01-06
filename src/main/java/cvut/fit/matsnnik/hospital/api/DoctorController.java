package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.DoctorModel;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorLoginDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    private DoctorModel fromEntity(DoctorEntity doctor){
        return new DoctorModel(doctor.getDid(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getdType(),
                doctor.getPassword());
    }

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody DoctorModel doctor){
        try{
            System.out.println("doctor name: " + doctor.getName());
            doctorService.registerDoctor(doctor.getDid(), doctor.getName(), doctor.getSurname(), doctor.getdType(), doctor.getPassword());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody DoctorLoginDTO doctor){
        try{
            System.out.println("doctor password: " + doctor.getPassword());
            boolean hasLoggedIn = doctorService.loginDoctor(doctor.getDid(), doctor.getPassword());
            System.out.println("hasLoggedIn:" + hasLoggedIn);
            if (!hasLoggedIn){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        }catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        DoctorEntity ent = doctorService.findByDid(doctor.getDid());
        return new ResponseEntity<>(
                "ent.getDid().toString()",
                HttpStatus.OK
        );
    }

    @GetMapping("/{did}")
    public ResponseEntity<DoctorModel> getDoctor(@PathVariable("did") int did){
        DoctorEntity doctorEntity = doctorService.findByDid(did);
        if (doctorEntity == null){
            throw new EntityNotFoundException();
        }
        DoctorModel doctorDTO = new DoctorModel(doctorEntity.getDid(),
                doctorEntity.getName(),
                doctorEntity.getSurname(),
                doctorEntity.getdType(),
                doctorEntity.getPassword());
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }

    @PutMapping("/{did}")
    public ResponseEntity<String> update(@RequestBody DoctorModel doctorDTO, @PathVariable("did") Integer did){
        try{
            DoctorEntity doctorEntity = doctorDTO.toEntity();
            doctorService.updateDoctor(doctorEntity, did);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{did}")
    public ResponseEntity<String> delete(@PathVariable("did") int id){
        try {
            doctorService.delete(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        List<DoctorModel> doctorsDTO = new ArrayList<>();
        for(DoctorEntity i : doctorService.getAll()){
            doctorsDTO.add(fromEntity(i));
        }
        return ResponseEntity.ok(doctorsDTO);
    }
}
