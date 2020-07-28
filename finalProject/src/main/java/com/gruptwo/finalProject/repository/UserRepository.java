package com.gruptwo.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gruptwo.finalProject.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	
}
