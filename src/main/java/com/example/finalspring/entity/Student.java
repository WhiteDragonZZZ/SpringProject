package com.example.finalspring.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;

@Entity
@Table(name = "student")
@Component
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "grade")
	private double grade;
	@Column(name = "role")
	private String role;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	public Student() {

	}

	public Student(int id, String name, String password, double grade, String role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.grade = grade;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@PostConstruct
	protected void init() {
		System.out.println("Student class was created");
	}

	@PreDestroy
	protected void destroy() {
		System.out.println("Student class was destroy");
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", grade=" + grade +
				", role='" + role + '\'' +
				", faculty=" + faculty +
				'}';
	}
}

