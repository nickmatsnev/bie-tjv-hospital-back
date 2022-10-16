package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;

@Entity
@Table(name = "Treated", schema = "public", catalog = "postgres")
public class TreatedEntity {
    @Basic
    @Column(name = "patient")
    private int patient;
    @Basic
    @Column(name = "operation")
    private int operation;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "treatedId")
    private int treatedId;

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

    public int getTreatedId() {
        return treatedId;
    }

    public void setTreatedId(int treatedId) {
        this.treatedId = treatedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatedEntity that = (TreatedEntity) o;

        if (patient != that.patient) return false;
        if (operation != that.operation) return false;
        if (treatedId != that.treatedId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patient;
        result = 31 * result + operation;
        result = 31 * result + treatedId;
        return result;
    }
}
