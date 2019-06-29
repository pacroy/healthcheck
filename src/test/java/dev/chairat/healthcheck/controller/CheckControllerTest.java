package dev.chairat.healthcheck.controller;

import dev.chairat.healthcheck.model.HealthcheckResult;
import dev.chairat.healthcheck.service.HealthcheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckControllerTest {

    @InjectMocks
    CheckController checkController;

    @Mock
    private HealthcheckService healthcheckService;

    @Test
    public void should_always_return_200() {
        // Given
        when(healthcheckService.check("http://localhost:8080/v2/actuator/health")).thenReturn(true);

        // When
        ResponseEntity<HealthcheckResult> responseEntity = checkController.check();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
