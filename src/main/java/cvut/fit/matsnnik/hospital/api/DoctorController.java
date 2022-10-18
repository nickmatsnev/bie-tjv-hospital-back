package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.DoctorDTO;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorLoginDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody DoctorDTO doctor){
        try{
            System.out.println(doctor.getName());
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
            System.out.println(doctor.getPassword());
            boolean hasLoggedIn = doctorService.loginDoctor(doctor.getDid(), doctor.getPassword());
            System.out.println(hasLoggedIn);
            if (!hasLoggedIn){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        }catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        DoctorEntity ent = doctorService.findByDid(doctor.getDid());
        return new ResponseEntity<>(
                "\"" + ent + "\"",
                HttpStatus.OK
        );
    }
    @GetMapping("/{did}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("did") int did){
        DoctorEntity doctorEntity = doctorService.findByDid(did);
        DoctorDTO doctorDTO = new DoctorDTO(doctorEntity.getDid(),
                doctorEntity.getName(),
                doctorEntity.getSurname(),
                doctorEntity.getdType(),
                doctorEntity.getPassword());
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }
}
