package com.StuDebate.StudentReg.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StuDebate.StudentReg.Model.Student;
import com.StuDebate.StudentReg.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	
	//this will return all students
	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll();
	}
	
	//this will save new Student
	@Override
	public void save(Student student) {
		studentRepo.save(student);
		
	}
	//this will delete a Student by ID
	@Override
	public void deleteByid(int id) {
		Student student=getStudentById(id);
		studentRepo.delete(student);
	}
	//this will get a Student by ID
	@Override
	public Student getStudentById(int id) {
		
		Optional<Student> optStudent= studentRepo.findById(id);
		if (optStudent.isPresent()) {
			return optStudent.get();
		}
		else {
			return null;
		}
	}

}
