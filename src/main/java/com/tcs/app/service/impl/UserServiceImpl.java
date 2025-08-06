package com.tcs.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.app.dao.UserDao;
import com.tcs.app.model.Persons;
import com.tcs.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	

	@Override
	public String addUser(Persons persons) {
		// TODO Auto-generated method stub
		return userDao.addUser(persons);
	}

	@Override
	public String updatePersonById(Persons persons) {
		String message = "";
		
		if(persons.getPersonId() != null) {
			Integer personDbId = userDao.getPersonById(persons.getPersonId());
			if(personDbId != null) {
				
				message = userDao.updatePersonById(persons);
				
			}else {
				message = "Pleasae enter valid person Id";
			}
			
		}else{
			message = "Pleasae enter person Id";
		}
		
		return message;
	}

	@Override
	public Persons getPersonByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
