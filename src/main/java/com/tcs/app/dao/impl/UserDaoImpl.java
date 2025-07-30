package com.tcs.app.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.tcs.app.dao.UserDao;
import com.tcs.app.model.Persons;
import com.tcs.app.util.DBConnectUtil;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public Persons getPersonsByLastName(String lastName) {
		Persons persons = null;
		String sqlQuery = "SELECT *FROM persons WHERE last_name in (?)";
		try {
		 PreparedStatement stmt =  DBConnectUtil.getDBConnection().prepareStatement(sqlQuery);
		 stmt.setString(1, lastName);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()) {
			 
			int personDBId = rs.getInt("person_id");
			 lastName =  rs.getString("last_name");
			int age = rs.getInt("age");
			String firstName =  rs.getString("first_name");
			
			 persons = new Persons();
			persons.setPersonId(personDBId);
			persons.setFirstName(firstName);
			persons.setLastName(lastName);
			persons.setAge(age);
		 }
		 
		}catch (SQLException e) {
			System.out.println("SQLException : " +e);
		}
		return persons;
	}

	@Override
	public String addUser(Persons persons) {
		String message = "";
		String sqlQuery = "INSERT INTO persons (first_name, last_name, age) Values(? , ?, ?)";
		try {
		 PreparedStatement stmt =  DBConnectUtil.getDBConnection().prepareStatement(sqlQuery);
		 stmt.setString(1, persons.getFirstName());
		 stmt.setString(2, persons.getLastName());
		 stmt.setInt(3, persons.getAge());
		 
		 int row = stmt.executeUpdate();
		 if(row > 0) {
			 message = "Person details saved successfully.."; 
		 }else {
			 
			 message = "Person details unable to save...."; 
		 }
		
		 
		}catch (SQLException e) {
			System.out.println("SQLException : " +e);
		}
		
		return message;
	}

	@Override
	public Integer getPersonById(Integer personId) {
		Integer personDBId = null;
		String sqlQuery = "SELECT person_id FROM persons WHERE person_id = ?";
		try {
		 PreparedStatement stmt =  DBConnectUtil.getDBConnection().prepareStatement(sqlQuery);
		 stmt.setInt(1, personId);
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()) {			 
			 personDBId = rs.getInt("person_id");
		 }
		 
		}catch (SQLException e) {
			System.out.println("SQLException : " +e);
		}
		return personDBId;
	}

	@Override
	public String updatePersonById(Persons persons) {
		String message = "";
		String sqlQuery = "UPDATE persons SET  last_name = ? , first_name = ? , age = ? WHERE person_id = ?";
		try {
		 PreparedStatement stmt =  DBConnectUtil.getDBConnection().prepareStatement(sqlQuery);
		 
		 stmt.setString(1, persons.getLastName());
		 stmt.setString(2, persons.getFirstName());
		 stmt.setInt(3, persons.getAge());
		 stmt.setInt(4, persons.getPersonId());
		 
		 int row = stmt.executeUpdate();
		 if(row > 0) {
			 message = "Person details updated successfully.."; 
		 }else {
			 
			 message = "Person details unable to update...."; 
		 }
		 
		}catch (SQLException e) {
			System.out.println("SQLException : " +e);
		}
		
		return message;
	}

}
