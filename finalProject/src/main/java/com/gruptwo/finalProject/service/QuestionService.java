package com.gruptwo.finalProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gruptwo.finalProject.entities.Question;
import com.gruptwo.finalProject.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionServ;
	
	//Save question method
	public Question saveQuestion(Question question) {
		return questionServ.save(question);		
	}// end method save
	
	//Delete a question by its id
	public void deleteQuestion(Integer id) {
		try {
			questionServ.deleteById(id);
		}catch(Exception e){
		}		
	}//End method delete
	
	//List all questions	
	public List<Question> questionList()	{
		return questionServ.findAll();
	}//End list method
	
	//Search a question by its id - podríamos usarlo en caso de añadir las respuestas múltiples
	public Question getQuestionById(Integer id) {
		return questionServ.findById(id).get();
	}

	
	
}// End Class 
