package com.demo.demo.StudentController;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.StudentModel.StudentModel;
import com.demo.demo.StudentService.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/all")
    public List<StudentModel> list() {
        return studentService.listAll();

    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/save")
    public String add(@RequestBody StudentModel student) {
        studentService.save(student);
        return "New Student Added";

    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> get(@PathVariable Long id) {
        try {
            StudentModel student = studentService.get(id);
            return new ResponseEntity<StudentModel>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> update(@PathVariable Long id, @RequestBody StudentModel student) {
        try {

            // StudentModel existingStudent = studentService.get(id);
            studentService.save(student);
            return new ResponseEntity<StudentModel>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND);

        }
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        studentService.delete(id);
        return "Student Deleted";

    }

}
