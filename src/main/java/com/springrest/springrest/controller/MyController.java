package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entitys.Student;
import com.springrest.springrest.services.StudentService;

@RestController
@RequestMapping("/MyController")//url restname
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	//Get the All Students
	@GetMapping("/getStudents")
	public List<Student> getStudents()
	{
	return this.studentService.getStudents();	
	}
	
	
	//Get the Single Student
	@GetMapping("/getStudent/{studentId}")
	public Student getStudent(@PathVariable String studentId)
	{
		return this.studentService.getStudent(Long.parseLong(studentId));
	}
	
	// add the student
	@PostMapping("/addStudent") //URL same But Methods different Get,Post
	public Student addStudent(@RequestBody Student student)
	{
		return this.studentService.addStudent(student);
	}
	
	//Update the Student using Put Request
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student)//request body se student ka obj lene k liye @requestBody annotation lagaya hai
	{
	    return this.studentService.updateStudent(student);
	}
	
	//delete the student
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId)
	{
		try
		{
			this.studentService.deleteStudent(Long.parseLong(studentId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
