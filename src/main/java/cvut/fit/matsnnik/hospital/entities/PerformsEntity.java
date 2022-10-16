package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Performs", schema = "public", catalog = "postgres")
public class PerformsEntity {
    @Basic
    @Column(name = "doctor")
    private Integer doctor;
    @Basic
    @Column(name = "operation")
    private int operation;

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformsEntity that = (PerformsEntity) o;
        return operation == that.operation && Objects.equals(doctor, that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, operation);
    }
}
