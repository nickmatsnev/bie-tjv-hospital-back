package cvut.fit.matsnnik.hospital.api.dtos;

import java.sql.Time;
import java.util.Collection;

public class SessionDTO {
    private Long plannedStart;
    private Long plannedEnd;
    private String name;
    private Collection<DoctorDTO> doctors;
    private Collection<PatientDTO> patients;

    public SessionDTO(String name, Long plannedStart, Long plannedEnd, Collection<DoctorDTO> doctors, Collection<PatientDTO> patients) {
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

    public Collection<DoctorDTO> getDoctors() {
        return doctors;
    }

    public Collection<PatientDTO> getPatients() {
        return patients;
    }
}
