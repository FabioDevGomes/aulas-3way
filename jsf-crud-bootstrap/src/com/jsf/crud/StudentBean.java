package com.jsf.crud;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.jsf.crud.db.operations.DatabaseOperation;

@ManagedBean 
@RequestScoped
//@SessionScoped
public class StudentBean {

	private int id;  
	private String name;  
	private String email;  
	private String password;  
	private String gender;  
	private String address;

	public ArrayList<StudentBean>studentsListFromDB;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}  
	
	/* Method Will Avoid Multiple Calls To DB For Fetching The Students Records. If This Is Not Used & Data Is Fetched From Getter Method, JSF DataTable Will Make Multiple Calls To DB*/
	@PostConstruct
	public void init() {
		studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

	/* Method Used To Fetch All Records From The Database */
	public ArrayList<StudentBean> studentsList() {
		return studentsListFromDB;
	}
	
	/* Method Used To Save New Student Record */
	public String saveStudentDetails(StudentBean newStudentObj) {
		return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
	}
	
	/* Method Used To Edit Student Record */
	public String editStudentRecord(int studentId) {
		return DatabaseOperation.editStudentRecordInDB(studentId);
	}
	
	/* Method Used To Update Student Record */
	public String updateStudentDetails(StudentBean updateStudentObj) {
		return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
	}
	
	/* Method Used To Delete Student Record */
	public String deleteStudentRecord(int studentId) {
		return DatabaseOperation.deleteStudentRecordInDB(studentId);
	}
}