package com.gruptwo.finalProject.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="question")
public class Question {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_question")
	private Integer idQuestion;
	
	@Column(name="bodyQ", nullable=false)
	private String bodyQ;
	
	@Transient
	private Integer idContainer;
	
	@Transient
	private String idAnswer;
	
	
	public Integer getIdContainer() {
		return idContainer;
	}

	public void setIdContainer(Integer idContainer) {
		this.idContainer = idContainer;
	}

	
	//Relations with entities
	//Container
	@ManyToOne
	@JoinColumn(name="id_container", nullable = true)
	private Container container;
	
	//Answer
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private Answer answer;	
	
	
	
	
	

	// Getters y Setters
	public Integer getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}


	public String getBodyQ() {
		return bodyQ;
	}


	public void setBodyQ(String bodyQ) {
		this.bodyQ = bodyQ;
	}


	public Container getContainer() {
		return container;
	}


	public void setContainer(Container container) {
		this.container = container;
	}


	public Answer getAnswer() {
		return answer;
	}


	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


	

	public String getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(String idAnswer) {
		this.idAnswer = idAnswer;
	}

	
		
	
}
