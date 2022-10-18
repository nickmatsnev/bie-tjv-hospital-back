package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "patient", schema = "public", catalog = "postgres")
public class PatientEntity {

    @Id
    @Column(name = "pid")
    private int pid;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "age")
    private int age;
    @Basic
    @Column(name = "password")
    private String password;


    @ManyToMany
    @JoinTable(
            name = "session",
            joinColumns = @JoinColumn(name = "patient"),
            inverseJoinColumns = @JoinColumn(name = "oid"))
    private Set<SessionEntity> sessions = new LinkedHashSet<>();


    public Set<SessionEntity> getSessions() {
        return sessions;
    }

    public void setSessions(Set<SessionEntity> sessions) {
        this.sessions = sessions;
    }


    public PatientEntity() {

    }
    public int getpid() {
        return pid;
    }

    public void setpid(int pId) {
        this.pid = pId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PatientEntity(int pid, String email, String name, String surname, int age, String password) {
        this.pid = pid;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return pid == that.pid && age == that.age && Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, email, name, surname, age);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
