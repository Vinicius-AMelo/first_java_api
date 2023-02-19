package com.hello_world.first_api_java.students;

import com.hello_world.first_api_java.ReturnMessage;
import com.hello_world.first_api_java.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ArrayList<StudentEntity> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentEntity getOneStudent(@PathVariable("id") int id){
        return studentService.getOneStudent(id);
    }

    @PostMapping("/")
    public ReturnMessage setStudents(@RequestBody StudentEntity newStudentEntity){
        return studentService.setStudents(newStudentEntity);
    }

    @PutMapping("/")
    public ReturnMessage putStudents(@RequestParam int id, @RequestBody StudentEntity newStudentEntity){
        return studentService.putStudents(id, newStudentEntity);
    }

    @DeleteMapping("/")
    public ReturnMessage deleteStudents(@RequestParam int id){
        return studentService.deleteStudents(id);
    }
}
