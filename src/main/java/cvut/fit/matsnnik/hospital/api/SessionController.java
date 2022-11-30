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
import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    private Time parseTime(String time){
        String[] timeStart = time.split ( ":" );
        int hour = Integer.parseInt ( timeStart[0].trim() );
        int min = Integer.parseInt ( timeStart[1].trim() );
        return new Time(hour, min, 0);
    }
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
            String[] split = session.getPatient().split("\\s+");
            String name = split[0];
            String surname = split[1];
            PatientEntity patient = patientService.findByNameAndSurname(name,surname);
            System.out.println("sessions patientEnt.name when created: " + patient.getName());
            System.out.println("doctor id which is sent to us" + session.getDoctor());
            DoctorEntity doctor = doctorService.findByDid(Math.toIntExact(session.getDoctor()));
            System.out.println("sessions doctorEnt.name when created: " + doctor.getName());

            Time start = parseTime(session.getPlannedStart());

            Time end = parseTime(session.getPlannedEnd());
            SessionEntity sessionEntity = new SessionEntity(
                    start,
                    end,
                    session.getName(),
                    doctor,
                    patient);
            System.out.println("patient: " + session.getPatient());
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
        SessionActualDTO sessionActualDTO = new SessionActualDTO(
                sessionEntity.getPlannedStart().toString(),
                sessionEntity.getPlannedEnd().toString(),
                sessionEntity.getName(),
                sessionEntity.getDoctor().getDid().longValue(),
                sessionEntity.getPatient().getName() + " " + sessionEntity.getPatient().getSurname()
        );
        return ResponseEntity.ok(sessionActualDTO);
    }

    @GetMapping("/session/name/{doctor}/{name}")
    public ResponseEntity getByNameAndDoctor(@PathVariable("doctor") int doctor, @PathVariable("name") String name){
        System.out.println("name of the session get" + name);
        SessionEntity sessionEntity = sessionService.getByNameAndDoctor(name, doctorService.findByDid(doctor));
        if(sessionEntity == null){
            throw new EntityNotFoundException();
        }
        SessionActualDTO sessionActualDTO = new SessionActualDTO(
                sessionEntity.getPlannedStart().toString(),
                sessionEntity.getPlannedEnd().toString(),
                sessionEntity.getName(),
                sessionEntity.getDoctor().getDid().longValue(),
                sessionEntity.getPatient().getName() + " " + sessionEntity.getPatient().getSurname()
        );
        return ResponseEntity.ok(sessionActualDTO);
    }
    @PostMapping("/session/name/{doctor}/{name}")
    public ResponseEntity<String> update(@PathVariable("doctor") int doctor, @PathVariable("name") String name, @RequestBody SessionActualDTO sessionDTO){
        try{
            System.out.println("name of the session in PUT query" + name);
            SessionEntity sessionEntity = sessionService.getByNameAndDoctor(name, doctorService.findByDid(doctor));
            if(sessionEntity == null){
                throw new EntityNotFoundException();
            }
            System.out.println("name of the session in PUT query after found entity : " + name);
            String[] split = sessionDTO.getPatient().split("\\s+");
            String name1 = split[0];
            String surname = split[1];
            System.out.println(name1 + " "  + surname);
            Time start = parseTime(sessionDTO.getPlannedStart());

            System.out.println("my tut");
            Time end = parseTime(sessionDTO.getPlannedEnd());
            sessionEntity.setName(sessionDTO.getName());
            System.out.println("my tut");
            sessionEntity.setActualEnd(start);
            sessionEntity.setActualStart(end);
            System.out.println("my tut");
            sessionEntity.setPatient(patientService.findByNameAndSurname(name1, surname));
            sessionEntity.setDoctor(doctorService.findByDid(Math.toIntExact(sessionDTO.getDoctor())));
            sessionService.updateSession(sessionEntity, sessionEntity.getOid());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                "successfully updated",
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
    public ResponseEntity getByPatientId(@PathVariable("id") Integer id){
        Collection<SessionModel> sessionModels;
        try{
            PatientEntity patient = patientService.findByPid(id);
            System.out.println("patient name: " + patient.getName());
            sessionModels = sessionService.findAllByPatient(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(sessionModels);
    }
    @GetMapping("/doctor/{id}")
    public ResponseEntity getByDoctorId(@PathVariable("id") Integer id){
        Collection<SessionModel> sessionModels;
        try{
            DoctorEntity doctor = doctorService.findByDid(id);
            System.out.println("doctor name: " + doctor.getName());
            sessionModels = sessionService.findAllByDoctor(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(sessionModels);
    }

}
