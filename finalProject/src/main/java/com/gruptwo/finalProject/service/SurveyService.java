package com.gruptwo.finalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gruptwo.finalProject.entities.Survey;
import com.gruptwo.finalProject.repository.SurveyRepository;



@Service
public class SurveyService {
	
	@Autowired
	SurveyRepository surveyRepo;

	//Save Survey method
	public Survey saveSurvey(Survey survey) {
		
		return surveyRepo.save(survey);		
	}// end method save

	//Delete a Survey by its id
	public void deleteSurvey(Integer id) {
		try {
			surveyRepo.deleteById(id);
		}catch(Exception e){
		}		
	}//End method delete

	//List all Survey	
	public List<Survey> surveyList()	{
		return surveyRepo.findAll();
	}//End list method

	//Search a Survey by its id - 
	public Survey getSurveyById(Integer id) {
		return surveyRepo.findById(id).get();
	}
	
	


	//Update Survey
	public ResponseEntity<Survey> updateSurvey (Survey survey) {
		Optional<Survey> optionalSurvey = surveyRepo.findById(survey.getIdSurvey());
		Survey updateSurvey = optionalSurvey.get();
		survey.setTitle(survey.getTitle());
		survey.setDescription(survey.getDescription());
		surveyRepo.save(survey);
		return ResponseEntity.ok(updateSurvey);
	}

	
	
	
	
//	public ResponseEntity<Survey> updateAndInsertSurvey (Survey survey) {
//		Optional<Survey> optionalSurvey = surveyRepo.findById(survey.getIdSurvey());
//		Survey updateSurvey = optionalSurvey.get();
//		survey.setTitle(survey.getTitle());
//		survey.setDescription(survey.getDescription());
//		survey.getId_container();
//		surveyRepo.save(survey);
//		return ResponseEntity.ok(updateSurvey);
//	}


}
