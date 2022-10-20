package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "doctor", schema = "public", catalog = "postgres")
public class DoctorEntity {

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
    @Column(name = "dtype")
    private String dType;
    @Basic
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "session",
            joinColumns = @JoinColumn(name = "doctors"),
            inverseJoinColumns = @JoinColumn(name = "oid"))
    private Set<SessionEntity> sessions = new LinkedHashSet<>();

    public Set<SessionEntity> getSessions() {
        return sessions;
    }

    public Set<SessionEntity> getSessionEntities() {
        return sessions;
    }

    public void setSessionEntities(Set<SessionEntity> sessionEntities) {
        this.sessions = sessionEntities;
    }

    public DoctorEntity(int did, String name, String surname, String dType, String password) {
        this.did = did;
        this.name = name;
        this.surname = surname;
        this.dType = dType;
        this.password = password;
    }

    public DoctorEntity() {

    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
