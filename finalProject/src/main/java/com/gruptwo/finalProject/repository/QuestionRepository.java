package com.gruptwo.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gruptwo.finalProject.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	// declaración métodos a usar en QuestionService
	
	

}
