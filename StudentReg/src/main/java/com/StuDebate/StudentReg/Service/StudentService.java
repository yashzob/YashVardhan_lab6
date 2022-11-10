package com.StuDebate.StudentReg.Service;

import java.util.List;

import com.StuDebate.StudentReg.Model.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public void save(Student student);
	public void deleteByid(int id);
	Student getStudentById(int id);
	
}
