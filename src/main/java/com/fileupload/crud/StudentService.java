package com.fileupload.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepo;
    public void sendData(Student student){
        studentRepo.save(student);
    }
    public List<Student> showAll(){
        return studentRepo.findAll();
    }
    public Optional<Student> update(int id){
         return studentRepo.findById(id);

    }

    public void delete(int id){
        studentRepo.deleteById(id);

    }

}
