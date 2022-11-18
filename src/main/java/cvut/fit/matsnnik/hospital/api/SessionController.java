package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.*;
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

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.sql.Time;
import java.util.*;

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
    public ResponseEntity<String> create(@RequestBody SessionActualDTO session){
        try{
            // session is passed absolutely correct
            PatientEntity patient = patientService.findByPid(Math.toIntExact(session.getPatient()));
            DoctorEntity doctor = doctorService.findByDid(Math.toIntExact(session.getDoctor()));
            SessionEntity sessionEntity = new SessionEntity(
                    new Time(session.getPlannedStart()),
                    new Time(session.getPlannedEnd()),
                    session.getName(),
                    doctor,
                    patient);
            System.out.println(session.getName());
            sessionService.create(sessionEntity);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                session.getName(),
                HttpStatus.OK
        );
    }

    @GetMapping("/session/{oid}")
    public ResponseEntity get(@PathVariable("oid") int oid){
        SessionEntity sessionEntity = sessionService.findByOid(oid);
        if(sessionEntity == null){
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(sessionEntity);
    }

    @PutMapping("/session/{oid}")
    public ResponseEntity<String> update(@PathVariable("oid") int oid, @RequestBody SessionDTO sessionDTO){
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
    @DeleteMapping("/session/{oid}")
    public ResponseEntity<String> delete(@PathVariable("oid") int oid){
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

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<SessionEntity>> getByPatientId(@PathVariable("id") Integer id){
        List<SessionEntity> sessions = null;
        try{
             PatientEntity patient = patientService.findByPid(id);
             System.out.println(patient.getName());
             sessions = sessionService.findAllByPatient(id);
             for(SessionEntity session: sessions){
                 System.out.println(session.getName());
             }
             System.out.println("ya pidaras");
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }
    @GetMapping("/doctor/{id}")
    public ResponseEntity getByDoctorId(@PathVariable("id") Integer id){
        Collection<SessionModel> sessionModels;
        try{
            DoctorEntity doctor = doctorService.findByDid(id);
            System.out.println(doctor.getName());
            sessionModels = sessionService.findAllByDoctor(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(sessionModels);
    }

}
