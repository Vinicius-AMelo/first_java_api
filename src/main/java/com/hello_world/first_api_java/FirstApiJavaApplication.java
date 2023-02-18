package com.hello_world.first_api_java;

import com.hello_world.first_api_java.exceptions.StudentNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
public class FirstApiJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApiJavaApplication.class, args);
    }


}
