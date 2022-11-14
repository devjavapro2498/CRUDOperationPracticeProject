package com.student.ST.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.ST.domain.Student;

@Repository
public  interface StudentRepository extends JpaRepository<Student, Long> {
	
}
