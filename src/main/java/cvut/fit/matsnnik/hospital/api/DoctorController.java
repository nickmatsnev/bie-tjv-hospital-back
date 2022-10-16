package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.DoctorDTO;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
