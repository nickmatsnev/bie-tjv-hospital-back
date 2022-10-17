package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.DoctorDTO;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorLoginDTO;
import cvut.fit.matsnnik.hospital.api.dtos.PatientDTO;
import cvut.fit.matsnnik.hospital.api.dtos.PatientLoginDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PatientDTO patient){
        try{
            patientService.register(patient.getPid(), patient.getEmail(), patient.getName(), patient.getSurname(), patient.getAge(), patient.getPassword());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody PatientLoginDTO patient){
        try{
            boolean hasLoggedIn = patientService.login(patient.getEmail(), patient.getPassword());
            if (!hasLoggedIn){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        }catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PatientEntity ent = patientService.findByEmail(patient.getEmail());
        return new ResponseEntity<>(
                "\"" + ent + "\"",
                HttpStatus.OK
        );
    }
}
