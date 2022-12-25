package cvut.fit.matsnnik.hospital.services.RequestSessionService;

import cvut.fit.matsnnik.hospital.entities.PatientEntity;
import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RequestSessionServiceTest extends BaseTest{
    @Test
    @DisplayName("Create request for session test")
    void createTest(){
        requestSessionService.create(this.entity);
        Mockito.verify(requestSessionRepository).saveAndFlush(this.entity);
        assertThat(this.entity.getSessionName()).isNotNull();
    }

    @Test
    @DisplayName("Read request for session test")
    void readTest(){
        RequestSessionEntity savedRequest = requestSessionService.create(this.entity);
        Mockito.verify(requestSessionRepository).saveAndFlush(this.entity);
        assertEquals(savedRequest.getRequestId(), this.entity.getRequestId());
    }

    @Test
    @DisplayName("Update request for session test")
    void updateTest(){
        RequestSessionEntity newRequest = this.entity;
        newRequest.setSessionName("Updated");
        requestSessionService.update(newRequest);
        Mockito.verify(requestSessionRepository).saveAndFlush(newRequest);
        assertThat(this.entity.getSessionName()).isEqualTo("Updated");
    }

    @Test
    @DisplayName("Delete request for session test")
    void deleteTest(){
        requestSessionService.delete(this.entity.getRequestId());
        Mockito.verify(requestSessionRepository).deleteById(this.entity.getRequestId());
    }
}
