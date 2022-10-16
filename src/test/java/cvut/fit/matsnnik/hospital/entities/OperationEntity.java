package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.sql.Time;

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

        if (oid != that.oid) return false;
        if (status != that.status) return false;
        if (plannedStart != null ? !plannedStart.equals(that.plannedStart) : that.plannedStart != null) return false;
        if (plannedEnd != null ? !plannedEnd.equals(that.plannedEnd) : that.plannedEnd != null) return false;
        if (actualStart != null ? !actualStart.equals(that.actualStart) : that.actualStart != null) return false;
        if (actualEnd != null ? !actualEnd.equals(that.actualEnd) : that.actualEnd != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (plannedStart != null ? plannedStart.hashCode() : 0);
        result = 31 * result + (plannedEnd != null ? plannedEnd.hashCode() : 0);
        result = 31 * result + (actualStart != null ? actualStart.hashCode() : 0);
        result = 31 * result + (actualEnd != null ? actualEnd.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
