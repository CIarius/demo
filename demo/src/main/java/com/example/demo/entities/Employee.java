package com.example.demo.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	//private Integer titleId;
	
	@ManyToOne
	private Title title;
	
	private String forename;
	private String surname;
	
	//private Integer genderId;
	
	@ManyToOne
	//@JoinColumn(name="gender", referencedColumnName="id")
	private Gender gender;
	
	private Date dateOfBirth;
	private Date dateOfHire;
	
	//private Integer departmentId;
	
	@ManyToOne
	//@JoinColumn(name="department", referencedColumnName="id")
	private Department department;
	
	//private Integer roleId;
	
	@ManyToOne
	//@JoinColumn(name="role", referencedColumnName="id")
	private Role role;
	
	//private Integer shiftId;
	
	@ManyToOne
	private Shift shift;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String forename, String surname, Date dateOfBirth,
			Date dateOfHire) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.dateOfHire = dateOfHire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
/*
	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
*/
	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}
/*
	public Integer getShiftId() {
		return shiftId;
	}

	public void setShiftId(Integer shiftId) {
		this.shiftId = shiftId;
	}
*/
	@Override
	public String toString() {
		return "Employee [id=" + id + ", forename=" + forename + ", surname=" + surname
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfHire=" + dateOfHire
				+ "]";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
/*
	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
*/

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}	
	
}
