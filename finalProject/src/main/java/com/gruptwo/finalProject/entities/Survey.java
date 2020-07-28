package com.gruptwo.finalProject.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="survey")

public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_survey")
	private Integer idSurvey;

	@Column(name="title", length=100, nullable=true, unique=false)
	private String title;

	@Column(name="description", length=255, nullable=true, unique=false)
	private String description;
	
	@Transient
	private Integer idUser;
	
	

	//Relations with entities
	//Container
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private Set<Container> id_container;

	//User
	
	@ManyToMany(mappedBy = "surveys")	
	private Set<User> surveys= new HashSet<>();
	

	
	//Answer
	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
	
	
	public Survey() {}
	
	public Survey(Integer idSurvey, String title, String description) {
		this.idSurvey=idSurvey;
		this.title = title;
		this.description=description;
		}
	
	
	
	

	// Getters y Setters 
	public Set<Container> getId_container() {
		return id_container;
	}

	public void setId_container(Set<Container> id_container) {
		this.id_container =  id_container;
	}

	// Getters - Setters 
	public Integer getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(Integer idSurvey) {
		this.idSurvey = idSurvey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Set<User> getSurveys() {
		return surveys;
	}

	public void setSurveys(Set<User> surveys) {
		this.surveys = surveys;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}



}
