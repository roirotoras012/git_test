package com.demo.demo.StudentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.StudentModel.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

}
