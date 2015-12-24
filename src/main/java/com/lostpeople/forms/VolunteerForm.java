package com.lostpeople.forms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="volunteerform")
public class VolunteerForm {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "findDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date findDate;
	
	@Column(name = "findLocation")
	private String findLocation;
	
	@Column(name = "phone")
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFindDate() {
		return findDate;
	}

	public void setFindDate(Date findDate) {
		this.findDate = findDate;
	}

	public String getFindLocation() {
		return findLocation;
	}

	public void setFindLocation(String findLocation) {
		this.findLocation = findLocation;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	@Column(name = "photo1")
	private String photo1;
	
	@Column(name = "photo2")
	private String photo2;
	
	@Column(name = "photo3")
	private String photo3;
}
