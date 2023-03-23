package com.example.receiverdemo;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.AnnotatedType;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReceiverdemoApplicationTests {

    @Autowired
    Foo foo;

    @Test
    void ecplivitReceiverParamIsAnnotatedWithValid() throws NoSuchMethodException {
        AnnotatedType validatedFoo = Foo.class.getMethod("validatedFoo").getAnnotatedReceiverType();
        assertNotNull(validatedFoo.getAnnotation(Valid.class));
    }

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
