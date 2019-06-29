package dev.chairat.healthcheck.controller;

import dev.chairat.healthcheck.model.HealthcheckResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckControllerTest {

    @Autowired
    CheckController checkController;

    @Test
    public void should_always_return_200() {
        // When
        ResponseEntity<HealthcheckResult> responseEntity = checkController.check();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
