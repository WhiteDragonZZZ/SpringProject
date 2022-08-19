package com.example.finalspring.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculty")
@Component
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "amount")
	private int amount;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "faculty")
	private List<Student> students;


	public Faculty() {
	}

	public Faculty(int id, String name, int amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@PostConstruct
	protected void init() {
		System.out.println("Faculty class was created");
	}

	@PreDestroy
	protected void destroy() {
		System.out.println("Faculty class was destroy");
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"id=" + id +
				", name='" + name + '\'' +
				", amount=" + amount +
				", students=" + students +
				'}';
	}
}
