package com.tcs.app.dao;

import java.util.List;

import com.tcs.app.model.Persons;

public interface UserDao {
	
	public List<Persons> getPersonsByLastName(String lastName);

	public String addUser(Persons persons);

	public Integer getPersonById(Integer personId);

	public String updatePersonById(Persons persons);
	
	

}
