package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
	private Long id;
	private String name;
	private String passport;

	public Student() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
}
