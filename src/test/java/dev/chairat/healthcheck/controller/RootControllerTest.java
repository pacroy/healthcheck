package dev.chairat.healthcheck.controller;

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
public class RootControllerTest {

    @Autowired
    RootController rootController;

    @Test
    public void should_return_200() {
        // When
        ResponseEntity<String> responseEntity = rootController.hello();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
