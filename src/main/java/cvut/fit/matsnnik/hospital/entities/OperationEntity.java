package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "Operation", schema = "public", catalog = "postgres")
public class OperationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "oid")
    private int oid;
    @Basic
    @Column(name = "plannedStart")
    private Time plannedStart;
    @Basic
    @Column(name = "plannedEnd")
    private Time plannedEnd;
    @Basic
    @Column(name = "actualStart")
    private Time actualStart;
    @Basic
    @Column(name = "actualEnd")
    private Time actualEnd;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "name")
    private String name;

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
        OperationEntity that = (OperationEntity) o;
        return oid == that.oid && status == that.status && Objects.equals(plannedStart, that.plannedStart) && Objects.equals(plannedEnd, that.plannedEnd) && Objects.equals(actualStart, that.actualStart) && Objects.equals(actualEnd, that.actualEnd) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, plannedStart, plannedEnd, actualStart, actualEnd, status, name);
    }
}
