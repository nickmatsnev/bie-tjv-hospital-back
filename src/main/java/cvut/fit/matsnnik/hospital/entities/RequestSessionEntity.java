package cvut.fit.matsnnik.hospital.entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "request_session", schema = "public", catalog = "postgres")
public class RequestSessionEntity {

    private static final AtomicInteger count = new AtomicInteger(0);
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "request_id")
    private int requestId;
    @Basic
    @Column(name = "patient_id")
    private int patientId;
    @Basic
    @Column(name = "doctor_id")
    private int doctorId;
    @Basic
    @Column(name = "start_time")
    private Time startTime;
    @Basic
    @Column(name = "end_time")
    private Time endTime;
    @Basic
    @Column(name = "session_name")
    private String sessionName;
    @Basic
    @Column(name = "status")
    private int status;

    public RequestSessionEntity() {
        this.requestId = count.incrementAndGet();
    }
    public RequestSessionEntity(int requestId, int patientId, int doctorId, Time startTime, Time endTime, String sessionName, int status) {
        this.requestId = requestId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionName = sessionName;
        this.status = status;
    }
    public RequestSessionEntity(int patientId, int doctorId, Time startTime, Time endTime, String sessionName, int status) {
        this.requestId = count.incrementAndGet();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionName = sessionName;
        this.status = status;
    }

    public RequestSessionEntity(int patientId, int doctorId, Time startTime, Time endTime, String sessionName) {
        this.requestId = count.incrementAndGet();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessionName = sessionName;
        this.status = 0;
        this.requestId = count.incrementAndGet();
    }
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestSessionEntity that = (RequestSessionEntity) o;
        return requestId == that.requestId && patientId == that.patientId && doctorId == that.doctorId && status == that.status && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(sessionName, that.sessionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, patientId, doctorId, startTime, endTime, sessionName, status);
    }
}
