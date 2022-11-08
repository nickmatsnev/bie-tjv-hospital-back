package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "session", schema = "public", catalog = "postgres")
public class SessionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "oid")
    private int oid;
    @Basic
    @Column(name = "plannedstart")
    private Time plannedstart;
    @Basic
    @Column(name = "plannedend")
    private Time plannedend;
    @Basic
    @Column(name = "actualstart")
    private Time actualstart;
    @Basic
    @Column(name = "actualend")
    private Time actualend;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "doctor")
    private int doctor;
    @Basic
    @Column(name = "patient")
    private int patient;
    @Basic
    @Column(name = "doctor")
    private Integer doctors;
    @Basic
    @Column(name = "patient")
    private Integer patients;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Time getPlannedstart() {
        return plannedstart;
    }

    public void setPlannedstart(Time plannedstart) {
        this.plannedstart = plannedstart;
    }

    public Time getPlannedend() {
        return plannedend;
    }

    public void setPlannedend(Time plannedend) {
        this.plannedend = plannedend;
    }

    public Time getActualstart() {
        return actualstart;
    }

    public void setActualstart(Time actualstart) {
        this.actualstart = actualstart;
    }

    public Time getActualend() {
        return actualend;
    }

    public void setActualend(Time actualend) {
        this.actualend = actualend;
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

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionEntity that = (SessionEntity) o;

        if (oid != that.oid) return false;
        if (status != that.status) return false;
        if (doctor != that.doctor) return false;
        if (patient != that.patient) return false;
        if (plannedstart != null ? !plannedstart.equals(that.plannedstart) : that.plannedstart != null) return false;
        if (plannedend != null ? !plannedend.equals(that.plannedend) : that.plannedend != null) return false;
        if (actualstart != null ? !actualstart.equals(that.actualstart) : that.actualstart != null) return false;
        if (actualend != null ? !actualend.equals(that.actualend) : that.actualend != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (plannedstart != null ? plannedstart.hashCode() : 0);
        result = 31 * result + (plannedend != null ? plannedend.hashCode() : 0);
        result = 31 * result + (actualstart != null ? actualstart.hashCode() : 0);
        result = 31 * result + (actualend != null ? actualend.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + doctor;
        result = 31 * result + patient;
        return result;
    }

    public Integer getDoctors() {
        return doctors;
    }

    public void setDoctors(Integer doctors) {
        this.doctors = doctors;
    }

    public Integer getPatients() {
        return patients;
    }

    public void setPatients(Integer patients) {
        this.patients = patients;
    }
}
