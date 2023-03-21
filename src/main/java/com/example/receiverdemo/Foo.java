package com.example.receiverdemo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
class Foo {
    @Min(0)
    @NotNull
    private Integer x;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public String standardFoo() {
        return "standard " + x;
    }

    public String validatedFoo(@Valid Foo this) {
        return "validated " + x;
    }
}
