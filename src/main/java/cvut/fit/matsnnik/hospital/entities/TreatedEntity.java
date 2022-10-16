package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Treated", schema = "public", catalog = "postgres")
public class TreatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "treatedId", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "patient")
    private int patient;
    @Basic
    @Column(name = "operation")
    private int operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
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
        TreatedEntity that = (TreatedEntity) o;
        return patient == that.patient && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, operation);
    }


}
