package com.example.finalspring.entity;


import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "credits")
	private int credits;

	@Column(name = "status")
	private String status;


	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "audience",
			joinColumns = @JoinColumn(name = "subject_id")
			,inverseJoinColumns = @JoinColumn(name = "teacher_id")
	)
	List<Teacher> teachers;

	public Subject() {
	}

	public Subject(int id, String name, int credits, String status) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", name='" + name + '\'' +
				", credits=" + credits +
				", status='" + status + '\'' +
				", teachers=" + teachers +
				'}';
	}
}
