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
	
	@RequestMapping("/home")
	public String test() {
		System.out.println("testing");
		return "403.jsp";
	} 
	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> student= studentService.getAllStudent();
		model.addAttribute("Student",student);
		return "list-Student.jsp";
	}
	
	@RequestMapping("/addStu")
	public String showNewStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("Student", student);
		return "Student-form.jsp";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("Student") Student student) {
		System.out.println(student);
		studentService.save(student);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		System.out.println("deleteter");
		studentService.deleteByid(id);
		return "redirect:/list";
		
	}
	
	@RequestMapping("/update")
	public String formForUpdate(Model model,@RequestParam("id") int id) {
		System.out.println("marrrie angelina");
		Student student = studentService.getStudentById(id);
		model.addAttribute("Student",student);
		return "Student-form.jsp";
	}
	
	
	
}
