package com.gruptwo.finalProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gruptwo.finalProject.entities.MultipleAnswer;
import com.gruptwo.finalProject.repository.MultipleAnswerRepository;

@Service
public class MultipleAnswerService {
	@Autowired
	MultipleAnswerRepository multipleAServ;

	//Save multipleAnswer method
	public MultipleAnswer saveMultipleA(MultipleAnswer multipleA) {
		return multipleAServ.save(multipleA);		
	}// end method save

	//Delete a multipleAnswer by its id
	public void deleteMultipleA(Integer id) {
		try {
			multipleAServ.deleteById(id);
		}catch(Exception e){
		}		
	}//End method delete

	//List all multipleAnswer	
	public List<MultipleAnswer> multipleAList()	{
		return multipleAServ.findAll();
	}//End list method

	//Search a multipleAnswer by its id - podríamos usarlo en caso de añadir las respuestas múltiples
	public MultipleAnswer getMultipleAById(Integer id) {
		return multipleAServ.findById(id).get();
	}


}
