package com.gruptwo.finalProject.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="container")
public class Container {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_container")
	private Integer idContainer;
	
	@Column(name="title", length=100, nullable=true, unique=false)
	private String title;

	// Relations with entities 
    //Question
	@OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();
	
	//Answer
	@OneToMany(mappedBy = "container", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
	
	//Survey
	@ManyToMany(mappedBy = "id_container", cascade = CascadeType.ALL)
	private Set<Survey> id_survey;

	@OneToMany(mappedBy = "containerMul", cascade = CascadeType.ALL)
    private List<MultipleAnswer> answersMul = new ArrayList<>();
	
	



	//Getters y Setters 
	public Integer getIdContainer() {
		return idContainer;
	}


	public void setIdContainer(Integer idContainer) {
		this.idContainer = idContainer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


	public Set<Survey> getId_survey() {
		return id_survey;
	}


	public void setId_survey(Set<Survey> id_survey) {
		this.id_survey = id_survey;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public List<MultipleAnswer> getAnswersMul() {
		return answersMul;
	}


	public void setAnswersMul(List<MultipleAnswer> answersMul) {
		this.answersMul = answersMul;
	}
	
	
}
