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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
            // convert doctorsDTO to doctors Entities
            Set<DoctorEntity> doctorEntitySet = new LinkedHashSet<>();
            for(DoctorDTO d : session.getDoctors()){
                DoctorEntity doctorEntity = doctorService.findByDid(d.getDid());
                doctorEntitySet.add(doctorEntity);
            }

            // convert patientsDTO to patients Entities
            Set<PatientEntity> patientEntitySet = new LinkedHashSet<>();
            for(PatientDTO p : session.getPatients()){
                PatientEntity patientEntity = patientService.findByPid(p.getPid());
                patientEntitySet.add(patientEntity);
            }
            System.out.println("DTO contents:");
            for(DoctorEntity d : doctorEntitySet){
                System.out.println(d.getName());
            }
            SessionEntity sessionEntity = new SessionEntity(new Time(session.getPlannedStart()),
                    new Time(session.getPlannedEnd()),
                    session.getName(),
                    doctorEntitySet,
                    patientEntitySet);

            sessionService.create(sessionEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                session.getName(),
                HttpStatus.OK
        );
    }
}
