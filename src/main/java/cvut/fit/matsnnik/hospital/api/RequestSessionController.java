package cvut.fit.matsnnik.hospital.api;

import cvut.fit.matsnnik.hospital.api.dtos.RequestModel;
import cvut.fit.matsnnik.hospital.api.dtos.SessionActualDTO;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import cvut.fit.matsnnik.hospital.services.interfaces.RequestSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;

@RestController
@RequestMapping("/requests")
public class RequestSessionController {

    private final RequestSessionService requestSessionService;

    @Autowired
    public RequestSessionController(RequestSessionService requestSessionService) {
        this.requestSessionService = requestSessionService;
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

}
