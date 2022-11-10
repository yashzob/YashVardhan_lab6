package com.StuDebate.StudentReg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StuDebate.StudentReg.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
		
}
