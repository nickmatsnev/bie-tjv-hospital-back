package cvut.fit.matsnnik.hospital.api.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;

import java.sql.Time;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SessionDTO {
    private Long plannedStart;
    private Long plannedEnd;
    private String name;

    private Set<DoctorDTO> doctors;
    private Set<PatientDTO> patients;

    public SessionDTO(String name, Long plannedStart, Long plannedEnd, Set<DoctorDTO> doctors, Set<PatientDTO> patients) {
        this.name = name;
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Long getPlannedStart() {
        return plannedStart;
    }

    public Long getPlannedEnd() {
        return plannedEnd;
    }

    public String getName() {
        return name;
    }

    public Set<DoctorDTO> getDoctors() {
        return doctors;
    }

    public Set<PatientDTO> getPatients() {
        return patients;
    }

    public SessionEntity toEntity(){
        Set<DoctorEntity> doctorEntities = null;
        for(DoctorDTO doctorDTO : doctors){
            doctorEntities.add(doctorDTO.toEntity());
        }
        Set<PatientEntity> patientEntities = null;
        for(PatientDTO patientDTO : patients){
            patientEntities.add(patientDTO.toEntity());
        }
        return new SessionEntity(new Time(getPlannedStart()), new Time(getPlannedStart()), getName(), doctorEntities, patientEntities);
    }
}
