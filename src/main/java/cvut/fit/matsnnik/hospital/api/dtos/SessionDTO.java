package cvut.fit.matsnnik.hospital.api.dtos;

import cvut.fit.matsnnik.hospital.entities.DoctorEntity;
import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;

import java.sql.Time;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SessionDTO {
    private Long plannedStart;
    private Long plannedEnd;
    private String name;
    private DoctorDTO doctor;
    private PatientDTO patient;

    public SessionDTO(String name, Long plannedStart, Long plannedEnd, DoctorDTO doctor, PatientDTO patient) {
        this.name = name;
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;
        this.doctor = doctor;
        this.patient = patient;
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

    public void setPlannedStart(Long plannedStart) {
        this.plannedStart = plannedStart;
    }

    public void setPlannedEnd(Long plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public SessionEntity toEntity(){
        return new SessionEntity(new Time(getPlannedStart()), new Time(getPlannedStart()), getName(), doctor.toEntity(), patient.toEntity());
    }
}
