package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Api(value = "Студенты", description = "Rest сервис для работы с профилими студентов")
@RestController
public class StudentController {
	final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@ApiOperation(value = "Получить всех студентов", response = Student.class, responseContainer = "List")
	@GetMapping("/students")
	public String getAll(Model model){
		model.addAttribute("students", service.getAll());
		return "students";
	}

	@ApiOperation(value = "Получить студента по ключу", response = Student.class)
	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@ApiOperation(value = "Добавить студента", response = Student.class)
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Student create(@RequestBody Student student) {
		if(student != null) {
			service.save(student);
			return student;
		}
		else
			throw new NullPointerException("Error. Student is empty");
	}

	@ApiOperation(value = "Удалить студента")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if(id != null)
			service.delete(id);
		else
			throw new NullPointerException("Error. Id is empty");
	}
}
