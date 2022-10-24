package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.DoctorDTO;
import cvut.fit.matsnnik.hospital.api.dtos.PatientDTO;
import cvut.fit.matsnnik.hospital.api.dtos.SessionDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import cvut.fit.matsnnik.hospital.services.interfaces.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public SessionController(SessionService sessionService, DoctorService doctorService, PatientService patientService){

        this.sessionService = sessionService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SessionDTO session){
        try{
            SessionEntity sessionEntity = session.toEntity();
            sessionService.create(sessionEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                session.getName(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{oid}")
    public ResponseEntity<String> get(@PathVariable int oid){
        try{
            SessionEntity sessionEntity = sessionService.findByOid(oid);
            sessionService.updateSession(sessionEntity, oid);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }

    @PutMapping("/{oid}")
    public ResponseEntity<String> update(@PathVariable int oid, @RequestBody SessionDTO sessionDTO){
        try{
            SessionEntity sessionEntity = sessionDTO.toEntity();
            sessionService.updateSession(sessionEntity, oid);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{oid}")
    public ResponseEntity<String> delete(@PathVariable int oid){
        try{
            sessionService.delete(oid);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "{}",
                HttpStatus.OK
        );
    }
}
