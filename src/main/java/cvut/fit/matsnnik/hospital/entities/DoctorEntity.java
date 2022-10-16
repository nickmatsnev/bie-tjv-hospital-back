package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Doctor", schema = "public", catalog = "postgres")
public class DoctorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "did")
    private int did;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "dType")
    private String dType;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return did == that.did && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(dType, that.dType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, name, surname, dType);
    }
}
