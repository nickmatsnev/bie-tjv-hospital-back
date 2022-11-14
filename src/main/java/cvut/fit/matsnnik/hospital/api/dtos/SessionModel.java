package cvut.fit.matsnnik.hospital.api.dtos;

import java.util.Objects;

public class SessionModel {
    private Long plannedStart;
    private Long plannedEnd;
    private String name;
    private Integer doctor;
    private Integer patient;

    public SessionModel() {
    }

    public SessionModel(Long plannedStart, Long plannedEnd, String name, Integer doctor, Integer patient) {
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;

        this.name = name;
        this.doctor = doctor;
        this.patient = patient;

    }

    public Long getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(Long plannedStart) {
        this.plannedStart = plannedStart;
    }

    public Long getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(Long plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }
}
