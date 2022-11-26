package cvut.fit.matsnnik.hospital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cvut.fit.matsnnik.hospital.api.dtos.SessionModel;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "session", schema = "public", catalog = "postgres")
public class SessionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "oid")
    private int oid;
    @Basic
    @Column(name = "plannedstart")
    private Time plannedStart;
    @Basic
    @Column(name = "plannedend")
    private Time plannedEnd;
    @Basic
    @Column(name = "actualstart")
    private Time actualStart;
    @Basic
    @Column(name = "actualend")
    private Time actualEnd;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "name")
    private String name;

    private static final AtomicInteger count = new AtomicInteger(0);
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor = new DoctorEntity();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient = new PatientEntity();

    public SessionEntity(int oid, Time plannedStart, Time plannedEnd, Time actualStart, Time actualEnd, int status, String name, DoctorEntity doctor, PatientEntity patient) {
        this.oid = oid;
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;
        this.actualStart = actualStart;
        this.actualEnd = actualEnd;
        this.status = status;
        this.name = name;
        this.doctor = doctor;
        this.patient = patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public SessionEntity(Time plannedStart, Time plannedEnd, String name,
                         DoctorEntity doctor, PatientEntity patient) {
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;
        this.actualEnd = plannedEnd;
        this.actualStart = plannedStart;
        this.name = name;
        this.status = (System.currentTimeMillis() < plannedEnd.getTime()) ? ((System.currentTimeMillis() < plannedStart.getTime()) ? 0 : 1) : 2;
        // 0 is not started entity, 1 is started and 2 is finished
        this.doctor = doctor;
        this.patient = patient;
        this.oid = count.incrementAndGet();
    }


    public SessionEntity() {
        this.oid = count.incrementAndGet();
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Time getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(Time plannedStart) {
        this.plannedStart = plannedStart;
    }

    public Time getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(Time plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public Time getActualStart() {
        return actualStart;
    }

    public void setActualStart(Time actualStart) {
        this.actualStart = actualStart;
    }

    public Time getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(Time actualEnd) {
        this.actualEnd = actualEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity that = (SessionEntity) o;
        return oid == that.oid && status == that.status && Objects.equals(plannedStart, that.plannedStart) && Objects.equals(plannedEnd, that.plannedEnd) && Objects.equals(actualStart, that.actualStart) && Objects.equals(actualEnd, that.actualEnd) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, plannedStart, plannedEnd, actualStart, actualEnd, status, name);
    }

    public static SessionModel toModel(SessionEntity session){
        SessionModel sessionModel = new SessionModel(session.getPlannedStart().getTime(),
                session.getPlannedEnd().getTime(),
                session.getName(),
                session.getDoctor().getDid(),
                session.getPatient().getpid());
        return sessionModel;
    }
}
