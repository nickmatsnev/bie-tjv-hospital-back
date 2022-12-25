package cvut.fit.matsnnik.hospital.services.SessionService;

import cvut.fit.matsnnik.hospital.entities.RequestSessionEntity;
import cvut.fit.matsnnik.hospital.entities.SessionEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SessionServiceTest extends BaseTest {
    @Test
    @DisplayName("Create session test")
    void createTest(){
        sessionService.create(this.entity);
        Mockito.verify(sessionRepository).saveAndFlush(this.entity);
        assertThat(this.entity.getName()).isNotNull();
    }

    @Test
    @DisplayName("Read session test")
    void readTest(){
        SessionEntity savedRequest = sessionService.create(this.entity);
        Mockito.verify(sessionRepository).saveAndFlush(this.entity);
        assertEquals(savedRequest.getOid(), this.entity.getOid());
    }

    @Test
    @DisplayName("Update session test")
    void updateTest(){
        SessionEntity newRequest = this.entity;
        newRequest.setName("Updated");
        sessionService.update(newRequest);
        Mockito.verify(sessionRepository).saveAndFlush(newRequest);
        assertThat(this.entity.getName()).isEqualTo("Updated");
    }

    @Test
    @DisplayName("Delete session test")
    void deleteTest(){
        sessionService.delete(this.entity.getOid());
        Mockito.verify(sessionRepository).deleteById(this.entity.getOid());
    }
}
