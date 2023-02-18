package com.hello_world.first_api_java.students;

import com.hello_world.first_api_java.ReturnMessage;
import com.hello_world.first_api_java.exceptions.StudentNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class StudentService {
    public StudentService() {}

    private ArrayList<StudentEntity> list = new ArrayList<>();
    private int id = 0;

    public ArrayList<StudentEntity> getAllStudents(){
        return list;
    }

    public StudentEntity getOneStudent(int id){
        StudentEntity studentEntity = list.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);

        if(studentEntity == null) throw new StudentNotFoundException("Estudante não encontrado");

        return studentEntity;
    }

    public ReturnMessage setStudents(StudentEntity newStudentEntity){
        newStudentEntity.setId(id++);
        list.add(newStudentEntity);
        return new ReturnMessage("Estudante Cadastrado");
    }

    public ReturnMessage putStudents(int id, StudentEntity newStudentEntity){
        int index = list.indexOf(list.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null));

        if (index < 0) throw new StudentNotFoundException("Estudante não encontrado");

        newStudentEntity.setId(id);
        list.set(index, newStudentEntity);
        return new ReturnMessage("Estudante " + id + " Modificado");

    }

    public ReturnMessage deleteStudents(int id){
        int index = list.indexOf(list.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null));

        if (index < 0) throw new StudentNotFoundException("Estudante não encontrado");

        list.remove(index);
        return new ReturnMessage("Estudante " + id + " Removido");

    }
}
