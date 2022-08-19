package com.example.finalspring.entity;

import javax.persistence.*;

@Entity
@Table(name = "audience")
public class Audience {
	@Id
	@Column(name = "teacher_id")
	private int t_id;

	@Column(name = "subject_id")
	private int s_id;

	@Transient
	private String audience;

	public Audience() {

	}

	public Audience(int t_id, int s_id, String audience) {
		this.t_id = t_id;
		this.s_id = s_id;
		this.audience = audience;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}
}
