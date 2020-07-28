package com.gruptwo.finalProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "multipleAnswer")
public class MultipleAnswer { // no sabemos cónmo lo vamos a utilizar

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_multiAnswer")
	private Integer idMultiAnswer;

	@Column(name = "bodyQ")
	private String bodyQ;

	@Column(name = "optionA")
	private String optionA;


	@Column(name = "optionB")
	private String optionB;

	@Column(name = "optionC")
	private String optionC;

	@Column(name = "optionD")
	private String optionD;
	
	@Transient
	private Integer idContainer;

	@Transient
	private String idAnswer;
	

	// Container
	@ManyToOne
	@JoinColumn(name = "id_container", nullable = true)
	private Container containerMul;
	
	public String getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(String idAnswer) {
		this.idAnswer = idAnswer;
	}
	
	
	public Integer getIdContainer() {
		return idContainer;
	}

	public void setIdContainer(Integer idContainer) {
		this.idContainer = idContainer;
	}

	// Getters y Setters
	public Integer getIdMultiAnswer() {
		return idMultiAnswer;
	}

	public void setIdMultiAnswer(Integer idMultiAnswer) {
		this.idMultiAnswer = idMultiAnswer;
	}

	public Container getContainerMul() {
		return containerMul;
	}

	public void setContainerMul(Container containerMul) {
		this.containerMul = containerMul;
	}

	public String getBodyQ() {
		return bodyQ;
	}

	public void setBodyQ(String bodyQ) {
		this.bodyQ = bodyQ;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
}
