package cvut.fit.matsnnik.hospital.api.dtos;

import java.sql.Time;
import java.util.Objects;

public class SessionActualDTO {
    private String plannedStart;
    private String plannedEnd;
    private String name;
    private Long doctor;
    private String patient;

    public SessionActualDTO() {
    }

    public SessionActualDTO(String plannedStart, String plannedEnd, String name, Long doctor, String patient) {
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;
        this.name = name;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(String plannedStart) {
        this.plannedStart = plannedStart;
    }

    public String getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(String plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDoctor() {
        return doctor;
    }

    public void setDoctor(Long doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionActualDTO that = (SessionActualDTO) o;
        return Objects.equals(plannedStart, that.plannedStart) && Objects.equals(plannedEnd, that.plannedEnd) && Objects.equals(name, that.name) && Objects.equals(doctor, that.doctor) && Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plannedStart, plannedEnd, name, doctor, patient);
    }
}
