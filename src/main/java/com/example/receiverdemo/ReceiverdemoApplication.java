package com.example.receiverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.AnnotatedType;

@SpringBootApplication
public class ReceiverdemoApplication {

    public static void main(String[] args) throws NoSuchMethodException {
        ConfigurableApplicationContext context = SpringApplication.run(ReceiverdemoApplication.class, args);
//        Foo fooBean = context.getBean(Foo.class);
//        fooBean.setX(5);
//        System.out.println(fooBean.standardFoo());
//        System.out.println(fooBean.validatedFoo());
//
//        fooBean.setX(-5);
//        System.out.println(fooBean.standardFoo());
//        System.out.println(fooBean.validatedFoo());
//
//        AnnotatedType validatedFoo = Foo.class.getMethod("validatedFoo").getAnnotatedReceiverType();
//        System.out.println(validatedFoo);
    }

}
