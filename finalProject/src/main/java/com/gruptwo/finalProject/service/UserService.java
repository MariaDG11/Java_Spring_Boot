package com.gruptwo.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gruptwo.finalProject.entities.User;

import com.gruptwo.finalProject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRep;

	//Save User method
	public User saveUser(User user) {
		return userRep.save(user);		
	}// end method save

	//Delete a User by its id
	public void deleteUser(Integer id) {
		try {
			userRep.deleteById(id);
		}catch(Exception e){
		}		
	}//End method delete

	//List all User	
	public List<User> userList()	{
		return userRep.findAll();
	}//End list method

	//Search a User by its id 
	public User getUserById(Integer id) {
		return userRep.findById(id).get();
	}

	//Update User
	public ResponseEntity<User> updateUser (User user) {   
		Optional<User> optionalUser = userRep.findById(user.getIdUser());
		User updateUser = optionalUser.get();
		user.setName(user.getName());
		user.setSurname(user.getSurname());
		user.setAge(user.getAge());
		userRep.save(user);
		return ResponseEntity.ok(updateUser);
	}


}
