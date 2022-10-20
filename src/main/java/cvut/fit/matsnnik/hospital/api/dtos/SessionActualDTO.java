package cvut.fit.matsnnik.hospital.api.dtos;

import java.sql.Time;

public class SessionActualDTO {
    private Time actualStart;
    private Time actualEnd;

    public SessionActualDTO(Time actualStart, Time actualEnd) {
        this.actualStart = actualStart;
        this.actualEnd = actualEnd;
    }

    public Time getActualStart() {
        return actualStart;
    }

    public Time getActualEnd() {
        return actualEnd;
    }
}
