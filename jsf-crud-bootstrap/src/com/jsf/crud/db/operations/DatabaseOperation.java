package com.jsf.crud.db.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.jsf.crud.StudentBean;

public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;

	/* Method To Establish Database Connection */
	public static Connection getConnection(){  
		try{  
			Class.forName("org.postgresql.Driver");     
			String db_url ="jdbc:postgresql://localhost:5432/students",
					db_userName = "postgres",
					db_password = "12345";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}

	/* Method To Fetch The Student Records From Database */
//	public static ArrayList<StudentBean> getStudentsListFromDB() {
//		ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();  
//		try {
//			int contador = 0;
//			
//			while(contador < 10) {  
//				StudentBean stuObj = new StudentBean(); 
//				stuObj.setId(contador);  
//				stuObj.setName("11111111 "+contador);  
//				stuObj.setEmail("setEmail "+contador);  
//				stuObj.setPassword("exemplo "+contador);  
//				stuObj.setGender("setGender "+contador);  
//				stuObj.setAddress("setAddress "+contador);  
//				studentsList.add(stuObj);  
//				contador++;
//			}   
//			System.out.println("Total Records Fetched: " + studentsList.size());
//		} catch(Exception sqlException) {
//			sqlException.printStackTrace();
//		} 
//		return studentsList;
//	}
	
	/* Method To Fetch The Student Records From Database */
	public static ArrayList<StudentBean> getStudentsListFromDB() {
		ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();  
		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student_record");    
			while(resultSetObj.next()) {  
				StudentBean stuObj = new StudentBean(); 
				stuObj.setId(resultSetObj.getInt("student_id"));  
				stuObj.setName(resultSetObj.getString("student_name"));  
				stuObj.setEmail(resultSetObj.getString("student_email"));  
				stuObj.setPassword(resultSetObj.getString("student_password"));  
				stuObj.setGender(resultSetObj.getString("student_gender"));  
				stuObj.setAddress(resultSetObj.getString("student_address"));  
				studentsList.add(stuObj);  
			}   
			System.out.println("Total Records Fetched: " + studentsList.size());
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		} 
		return studentsList;
	}

	/* Method Used To Save New Student Record In Database */
	public static String saveStudentDetailsInDB(StudentBean newStudentObj) {
		int saveResult = 0;
		String navigationResult = "";
		try {      
			pstmt = getConnection().prepareStatement("insert into student_record (student_name, student_email, student_password, student_gender, student_address) values (?, ?, ?, ?, ?)");			
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getEmail());
			pstmt.setString(3, newStudentObj.getPassword());
			pstmt.setString(4, newStudentObj.getGender());
			pstmt.setString(5, newStudentObj.getAddress());
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "studentsList.xhtml?faces-redirect=true";
		} else {
			navigationResult = "createStudent.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	/* Method Used To Edit Student Record In Database */
	public static String editStudentRecordInDB(int studentId) {
		StudentBean editRecord = null;
		System.out.println("editStudentRecordInDB() : Student Id: " + studentId);

		/* Setting The Particular Student Details In Session */
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student_record where student_id = "+studentId);    
			if(resultSetObj != null) {
				resultSetObj.next();
				editRecord = new StudentBean(); 
				editRecord.setId(resultSetObj.getInt("student_id"));
				editRecord.setName(resultSetObj.getString("student_name"));
				editRecord.setEmail(resultSetObj.getString("student_email"));
				editRecord.setGender(resultSetObj.getString("student_gender"));
				editRecord.setAddress(resultSetObj.getString("student_address"));
				editRecord.setPassword(resultSetObj.getString("student_password")); 
			}
			sessionMapObj.put("editRecordObj", editRecord);
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editStudent.xhtml?faces-redirect=true";
	}

	/* Method Used To Update Student Record In Database */
	public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
		try {
			pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, student_password=?, student_gender=?, student_address=? where student_id=?");    
			pstmt.setString(1,updateStudentObj.getName());  
			pstmt.setString(2,updateStudentObj.getEmail());  
			pstmt.setString(3,updateStudentObj.getPassword());  
			pstmt.setString(4,updateStudentObj.getGender());  
			pstmt.setString(5,updateStudentObj.getAddress());  
			pstmt.setInt(6,updateStudentObj.getId());  
			pstmt.executeUpdate();
			connObj.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}

	/* Method Used To Delete Student Record From Database */
	public static String deleteStudentRecordInDB(int studentId){
		System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
		try {
			pstmt = getConnection().prepareStatement("delete from student_record where student_id = "+studentId);  
			pstmt.executeUpdate();  
			connObj.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}
}