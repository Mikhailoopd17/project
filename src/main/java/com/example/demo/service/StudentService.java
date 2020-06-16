package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	final StudentRepo studentRepo;

	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	public Student getById(Long id) {
		return studentRepo.findById(id).get();
	}

	public void save(Student student) {
		if(student != null && isAlreadyExsistPassport(student.getPassport())) {
			studentRepo.save(student);
		}

	}

	public void delete(Long id) {
		if(getById(id) == null || id < 1)
			throw new NullPointerException("Error. Student not found");
		else
			studentRepo.deleteById(id);
	}

	private boolean isAlreadyExsistPassport(String passport){
		List<Student> list = getAll();
		for (Student st : list) {
			if(st.getPassport().equals(passport))
				return true;
		}
		return false;
	}
}
