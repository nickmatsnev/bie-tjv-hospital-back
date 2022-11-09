package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.DoctorDTO;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorLoginDTO;
import cvut.fit.matsnnik.hospital.api.dtos.PatientDTO;
import cvut.fit.matsnnik.hospital.api.dtos.PatientLoginDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @GetMapping("/{pid}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("pid") int pid){
        PatientEntity patientEntity = patientService.findByPid(pid);
        PatientDTO patientDTO = new PatientDTO(patientEntity.getpid(),
                patientEntity.getEmail(),
                patientEntity.getName(),
                patientEntity.getSurname(),
                patientEntity.getAge(),
                patientEntity.getPassword());
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PatientDTO> getPatientByEmail(@PathVariable("email") String email){
        PatientEntity patientEntity = patientService.findByEmail(email);
        PatientDTO patientDTO = new PatientDTO(patientEntity.getpid(),
                patientEntity.getEmail(),
                patientEntity.getName(),
                patientEntity.getSurname(),
                patientEntity.getAge(),
                patientEntity.getPassword());
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<String> update(@RequestBody PatientDTO patientDTO, @PathVariable("pid") int pid){
        try{
            PatientEntity patientEntity = patientDTO.toEntity();
            patientService.updatePatient(patientEntity, pid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        try{
            patientService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientEntity>> getAllPatients(){
        List<PatientEntity> patientEntities = null;
        try {
            patientEntities = patientService.getAll();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(patientEntities);
    }
}
