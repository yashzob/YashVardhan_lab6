package com.StuDebate.StudentReg.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.StuDebate.StudentReg.Model.Student;
import com.StuDebate.StudentReg.Service.StudentService;


@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> student= studentService.getAllStudent();
		model.addAttribute("Student",student);
		return "403.jsp";
	}
	
	@RequestMapping("/showNewStudentForm")
	public String showNewStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("Student", student);
		return "Student-form";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.save(student);
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteByid(id);
		return "redirect:/students/list";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String formForUpdate(Model model,@RequestParam("id") int id) {
		
		Student student = studentService.getStudentById(id);
		model.addAttribute("Student",student);
		return "Student-form";
	}
	
	
	
}
