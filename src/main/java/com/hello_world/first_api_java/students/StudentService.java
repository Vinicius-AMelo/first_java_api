package com.hello_world.first_api_java.students;

import com.hello_world.first_api_java.ReturnMessage;
import com.hello_world.first_api_java.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public StudentEntity getOneStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Estudante não encontrado"));
    }

    public ReturnMessage postStudents(StudentEntity studentDTO) {
        studentRepository.save(studentDTO);

        return new ReturnMessage("O Estudante foi cadastrado");
    }

    public ReturnMessage putStudents(Long id, StudentEntity studentDTO) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Estudante não encontrado"));
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setCourse(studentDTO.getCourse());
        studentRepository.save(student);

        return new ReturnMessage("O Estudante " + student.getId() + " foi modificado");

    }

    public ReturnMessage deleteStudents(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Estudante não encontrado"));
        studentRepository.deleteById(student.getId());

        return new ReturnMessage("O Estudante " + id + " foi removido");

    }
}
