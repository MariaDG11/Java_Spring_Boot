package com.gruptwo.finalProject.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_answer")
	private Integer idAnswer;
	
	@Column(name="bodyAnswer")
	private String bodyAnswer;
	
	// Relations with entities 
	//Question
	@OneToOne
	@JoinColumn(name="id_question", nullable = false)
	private Question question;
	
	//User
	@ManyToOne
	@JoinColumn(name="id_user", nullable = false)
	private User user;
	
	//Container
	@ManyToOne
	@JoinColumn(name="id_container", nullable = false)
	private Container container;
	
	//Survey
	@ManyToOne
	@JoinColumn(name="id_survey", nullable = false)
	private Survey survey;
	
	//MultipleAnswers
	@OneToOne
	@JoinColumn(name="id_multiAnswer", nullable = false)
	private MultipleAnswer answerMul;
	
	

	//Getters y Setters
	public Integer  getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Integer  idAnswer) {
		this.idAnswer = idAnswer;
	}

	public String getBodyAnswer() {
		return bodyAnswer;
	}

	public void setBodyAnswer(String bodyAnswer) {
		this.bodyAnswer = bodyAnswer;
	}


	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public MultipleAnswer getAnswerMul() {
		return answerMul;
	}

	public void setAnswerMul(MultipleAnswer answerMul) {
		this.answerMul = answerMul;
	}
	
	
	
}
