package com.gruptwo.finalProject.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Table(name="user")
public class User {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Integer idUser;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "surname")
	private String surname;
	
	@Column (name = "age")
	private Integer age;
	
	//Relations with entities
	//Answer
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
	
//	//Survey
//	@ManyToMany(mappedBy = "id_user", cascade = CascadeType.ALL)
//	private Set<Survey> id_survey;
//	

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "survey_id_user")
    private Set<Survey> surveys;
	
	@Transient
	private Integer idSurvey;
	
	
	public Set<Survey> getSurveys() {
		return surveys;
	}


	public void setSurveys(Set<Survey> surveys) {
		this.surveys = surveys;
	}


	public User(Integer idUser, String name,String surname, Integer age, Survey surveys) {
        this.idUser= idUser;
		this.name = name;
        this.surname = surname;
        this.age= age;
        this.surveys = Stream.of(surveys).collect(Collectors.toSet());
        this.surveys.forEach(x -> x.getSurveys().add(this));
       
    }


	public User() {}

	
	
	
	
	
		
	//Getters y Setters 
	
	
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	

	

	

	public Integer getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(Integer idSurvey) {
		this.idSurvey = idSurvey;
	}

	

	

}
