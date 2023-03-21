package com.example.receiverdemo;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReceiverdemoApplicationTests {

    @Autowired
    Foo foo;

    @Test
    void shouldWorkForObjectWithValidState() {
        foo.setX(10);
        assertAll(
                () -> assertDoesNotThrow(() -> foo.validatedFoo()),
                () -> assertDoesNotThrow(() -> foo.standardFoo()),
                () -> assertEquals("standard 10", foo.standardFoo()),
                () -> assertEquals("validated 10", foo.validatedFoo())
        );
    }

    @Test
    void shouldFailForObjectWithInvalidState() {
        foo.setX(-10);
        assertAll(
                () -> assertDoesNotThrow(() -> foo.standardFoo()),
                () -> assertThrows(ConstraintViolationException.class, () -> foo.validatedFoo())
        );
    }

}
