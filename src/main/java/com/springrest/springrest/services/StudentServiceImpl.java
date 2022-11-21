package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.StudentDao;
import com.springrest.springrest.entitys.Student;

//ye class service layer par kaam kar rahi hai isly @service ka annotation lagaya hai
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
	private StudentDao studentDao;

    public StudentServiceImpl() {
		
	}

	@Override
	public List<Student> getStudents() {
		
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(long studentId) {
		
		return studentDao.getOne(studentId);
	}
	
	@Override
	public Student addStudent(Student student) {

		studentDao.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {

		studentDao.save(student);
		return student;
	}

	@Override
	public void deleteStudent(long parseLong) {
      Student entity = studentDao.getOne(parseLong);
		studentDao.delete(entity);
	}

}
