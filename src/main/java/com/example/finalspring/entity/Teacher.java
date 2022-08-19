package com.example.finalspring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;

	@Column(name = "hours")
	private int hours;


	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "audience",
			joinColumns = @JoinColumn(name = "teacher_id")
			,inverseJoinColumns = @JoinColumn(name = "subject_id")
	)
	private List<Subject> subjects;

	public Teacher() {

	}

	public Teacher(int id, String name, String role, int hours) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.hours = hours;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
}
