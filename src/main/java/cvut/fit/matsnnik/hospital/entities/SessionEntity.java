package cvut.fit.matsnnik.hospital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.print.Doc;
import java.sql.Time;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
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
    @ManyToMany(mappedBy = "sessions")
    private Set<DoctorEntity> doctors = new LinkedHashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "sessions")
    private Set<PatientEntity> patients = new LinkedHashSet<>();

    public SessionEntity(Time plannedStart, Time plannedEnd, String name,
                         Set<DoctorEntity> doctors, Set<PatientEntity> patients) {
        this.plannedStart = plannedStart;
        this.plannedEnd = plannedEnd;
        this.name = name;
        this.status = (System.currentTimeMillis() < plannedEnd.getTime()) ? ((System.currentTimeMillis() < plannedStart.getTime()) ? 0 : 1) : 2;
        // 0 is not started entity, 1 is started and 2 is finished
        this.doctors = doctors;
        this.patients = patients;
        this.oid = count.incrementAndGet();
    }

    public SessionEntity() {
    }

    public Set<DoctorEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<DoctorEntity> doctors) {
        this.doctors = doctors;
    }

    public Set<PatientEntity> getPatients() {
        return patients;
    }

    public void setPatients(Set<PatientEntity> patients) {
        this.patients = patients;
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
}
