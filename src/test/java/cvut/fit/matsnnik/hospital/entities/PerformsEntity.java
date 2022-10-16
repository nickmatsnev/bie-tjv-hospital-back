package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;

@Entity
@Table(name = "Performs", schema = "public", catalog = "postgres")
public class PerformsEntity {
    @Basic
    @Column(name = "doctor")
    private Integer doctor;
    @Basic
    @Column(name = "operation")
    private int operation;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "performsId")
    private int performsId;

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

    public int getPerformsId() {
        return performsId;
    }

    public void setPerformsId(int performsId) {
        this.performsId = performsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerformsEntity that = (PerformsEntity) o;

        if (operation != that.operation) return false;
        if (performsId != that.performsId) return false;
        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctor != null ? doctor.hashCode() : 0;
        result = 31 * result + operation;
        result = 31 * result + performsId;
        return result;
    }
}
