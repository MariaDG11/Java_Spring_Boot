package com.gruptwo.finalProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gruptwo.finalProject.entities.Answer;
import com.gruptwo.finalProject.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	AnswerRepository answerRep;
	
	//Save Answer method
	public Answer saveAnswer(Answer answer) {
		return answerRep.save(answer);		
	}// end method save
	
	//Delete a Answer by its id
	public void deleteAnswer(Integer id) {
		try {
			answerRep.deleteById(id);
		}catch(Exception e){
		}		
	}//End method delete
	
	//List all Answer	
	public List<Answer> answerList()	{
		return answerRep.findAll();
	}//End list method
	
	//Search a Answer by its id 
	public Answer getAnswerById(Integer id) {
		return answerRep.findById(id).get();
	}
	

}

