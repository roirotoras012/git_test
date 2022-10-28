package com.demo.demo.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.StudentModel.StudentModel;
import com.demo.demo.StudentRepository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentModel> listAll() {
        return studentRepository.findAll();

    }

    public void save(StudentModel student) {
        studentRepository.save(student);

    }

    public StudentModel get(Long id) {
        return studentRepository.findById(id).get();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);

    }
}
