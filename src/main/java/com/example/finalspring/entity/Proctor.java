package com.example.finalspring.entity;


import com.example.finalspring.CustomValidation.CheckName;

import javax.persistence.*;

@Entity
@Table(name = "proctor")
public class Proctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@CheckName
	@Column(name = "name")
	private String name;

	@Column(name = "type_of_work")
	private String work;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id")
	private Exam exam;

	public Proctor() {

	}

	public Proctor(int id, String name, String work, Exam exam) {
		this.id = id;
		this.name = name;
		this.work = work;
		this.exam = exam;
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

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Proctor{" +
				"id=" + id +
				", name='" + name + '\'' +
				", work='" + work + '\'' +
				", exam=" + exam +
				'}';
	}
}
