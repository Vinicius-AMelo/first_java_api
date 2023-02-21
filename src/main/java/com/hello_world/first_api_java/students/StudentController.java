package com.hello_world.first_api_java.students;

import com.hello_world.first_api_java.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<StudentEntity> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentEntity getOneStudent(@PathVariable("id") Long id){
        return studentService.getOneStudent(id);
    }

    @PostMapping("/")
    public ReturnMessage setStudents(@RequestBody StudentEntity newStudentEntity){
        return studentService.setStudents(newStudentEntity);
    }

    @PutMapping("/")
    public ReturnMessage putStudents(@RequestParam Long id, @RequestBody StudentEntity newStudentEntity){
        return studentService.putStudents(id, newStudentEntity);
    }

    @DeleteMapping("/")
    public ReturnMessage deleteStudents(@RequestParam Long id){
        return studentService.deleteStudents(id);
    }
}
