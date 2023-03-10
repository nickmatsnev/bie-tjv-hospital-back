package cvut.fit.matsnnik.hospital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cvut.fit.matsnnik.hospital.api.dtos.DoctorModel;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.*;
import java.util.HashSet;
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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<SessionEntity> sessions = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "hospital",
            joinColumns = @JoinColumn(name = "doctors"),
            inverseJoinColumns = @JoinColumn(name = "patients"))
    private Set<PatientEntity> patientsOfTheHospital;
    public Set<SessionEntity> getSessions() {
        return sessions;
    }


    public void setSessions(Set<SessionEntity> sessionEntities) {
        this.sessions = sessionEntities;
    }

    public DoctorEntity(Integer did, String name, String surname, String dType, String password) {
        this.did = did;
        this.name = name;
        this.surname = surname;
        this.dType = dType;
        this.password = password;
    }

    public DoctorEntity() {

    }

    public Integer getDid() {
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


    public DoctorModel toModel(){
        return new DoctorModel(1, name, surname, dType, password);
    }

}
