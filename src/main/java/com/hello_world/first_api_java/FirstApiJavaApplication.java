package com.hello_world.first_api_java;

import com.hello_world.first_api_java.exceptions.StudentNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class FirstApiJavaApplication {

    private ArrayList<Student> list = new ArrayList<>();
    private int id = 0;

    public static void main(String[] args) {
        SpringApplication.run(FirstApiJavaApplication.class, args);
    }

    @GetMapping("/")
    public ArrayList<Student> getStudents(){
        return list;
    }

    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable("id") int id){
        Student student = list.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);

        if(student == null) throw new StudentNotFoundException("Estudante não encontrado");

        return student;
    }

    @PostMapping("/")
    public ReturnMessage setStudents(@RequestBody Student newStudent){
        newStudent.setId(id++);
        list.add(newStudent);
        return new ReturnMessage("Estudante Cadastrado");
    }

    @PutMapping("/")
    public ReturnMessage putStudents(@RequestParam int id, @RequestBody Student newStudent){
        int index = list.indexOf(list.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null));

        if (index < 0) throw new StudentNotFoundException("Estudante não encontrado");

        newStudent.setId(id);
        list.set(index, newStudent);
        return new ReturnMessage("Estudante " + id + " Modificado");

    }

    @DeleteMapping("/")
    public ReturnMessage deleteStudents(@RequestParam int id){
        int index = list.indexOf(list.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null));
        if (index < 0) throw new StudentNotFoundException("Estudante não encontrado");

        list.remove(index);
        return new ReturnMessage("Estudante " + id + " Removido");

    }
}
