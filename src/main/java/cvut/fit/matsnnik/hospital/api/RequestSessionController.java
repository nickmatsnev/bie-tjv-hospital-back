package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.RequestModel;
import cvut.fit.matsnnik.hospital.api.dtos.SessionActualDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.DoctorService;
import cvut.fit.matsnnik.hospital.services.interfaces.PatientService;
import cvut.fit.matsnnik.hospital.services.interfaces.RequestSessionService;
import cvut.fit.matsnnik.hospital.services.interfaces.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestSessionController {

    private final RequestSessionService requestSessionService;
    private final SessionService sessionService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    private RequestModel fromEntity(RequestSessionEntity requestSessionEntity){
        return new RequestModel(requestSessionEntity.getPatientId(),
                requestSessionEntity.getDoctorId(),
                requestSessionEntity.getStartTime(),
                requestSessionEntity.getEndTime(),
                requestSessionEntity.getSessionName());
    }

    private List<RequestModel> fromListOfEntities(List<RequestSessionEntity> requests){
        List<RequestModel> models = new ArrayList<>();
        for(RequestSessionEntity requestSession : requests){
            models.add(fromEntity(requestSession));
        }
        return models;
    }

    @Autowired
    public RequestSessionController(RequestSessionService requestSessionService,
                                    SessionService sessionService,
                                    DoctorService doctorService,
                                    PatientService patientService) {
        this.requestSessionService = requestSessionService;
        this.sessionService = sessionService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody RequestModel requestModel){
        try{
            requestSessionService.create(requestModel.toEntity());

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                requestModel.getSessionName(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer requestId){
        return ResponseEntity.ok(fromEntity(requestSessionService.getById(requestId)));
    }

    @GetMapping("/pending/doctor/{id}")
    public ResponseEntity getPendingRequestsByDoctorId(@PathVariable("id") Integer doctorId){
        return ResponseEntity.ok(fromListOfEntities(requestSessionService.getPendingRequestsByDoctorId(doctorId)));
    }
    @GetMapping("/rejected/doctor/{id}")
    public ResponseEntity getRejectedRequestsByDoctorId(@PathVariable("id") Integer doctorId){
        return ResponseEntity.ok(fromListOfEntities(requestSessionService.getRejectedRequestsByDoctorId(doctorId)));
    }
    @GetMapping("/pending/patient/{id}")
    public ResponseEntity getPendingRequestsByPatientId(@PathVariable("id") Integer patientId){
        return ResponseEntity.ok(fromListOfEntities(requestSessionService.getPendingRequestsByPatientId(patientId)));
    }
    @GetMapping("/rejected/patient/{id}")
    public ResponseEntity getRejectedRequestsByPatientId(@PathVariable("id") Integer patientId){
        return ResponseEntity.ok(fromListOfEntities(requestSessionService.getRejectedRequestsByPatientId(patientId)));
    }

    @GetMapping("/accept/{name}/{doctor}/{patient}")
    public ResponseEntity accept(@PathVariable("name") String name, @PathVariable("doctor") Integer doctorId, @PathVariable("patient") Integer patientId){
        RequestSessionEntity requestSessionEntity = requestSessionService.getEntityByNameAndDoctorAndPatient(name, doctorId, patientId);
        requestSessionEntity.setStatus(1);
        requestSessionService.create(requestSessionEntity);
        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setDoctor(doctorService.findByDid(requestSessionEntity.getDoctorId()));
        sessionEntity.setPatient(patientService.findByPid(requestSessionEntity.getPatientId()));
        sessionEntity.setPlannedStart(requestSessionEntity.getStartTime());
        sessionEntity.setPlannedEnd(requestSessionEntity.getEndTime());
        sessionEntity.setName(requestSessionEntity.getSessionName());
        sessionService.create(sessionEntity);
        String reply = "Success! Session " + sessionEntity.getName() + " is created!";
        return ResponseEntity.ok(reply);
    }
    @GetMapping("/reject/{name}/{doctor}/{patient}")
    public ResponseEntity reject(@PathVariable("name") String name, @PathVariable("doctor") Integer doctorId, @PathVariable("patient") Integer patientId){
        RequestSessionEntity requestSessionEntity = requestSessionService.getEntityByNameAndDoctorAndPatient(name, doctorId, patientId);
        System.out.println(name);
        System.out.println(doctorId);
        System.out.println(patientId);
        requestSessionEntity.setStatus(2);
        requestSessionService.create(requestSessionEntity);
        String reply = "Success! Request session " + requestSessionEntity.getSessionName() + " is rejected!";
        return ResponseEntity.ok(reply);
    }

}
