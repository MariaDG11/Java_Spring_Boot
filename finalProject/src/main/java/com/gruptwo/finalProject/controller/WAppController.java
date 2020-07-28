package com.gruptwo.finalProject.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gruptwo.finalProject.entities.Container;
import com.gruptwo.finalProject.entities.MultipleAnswer;
import com.gruptwo.finalProject.entities.Question;
import com.gruptwo.finalProject.entities.Survey;
import com.gruptwo.finalProject.entities.User;
import com.gruptwo.finalProject.repository.UserRepository;
import com.gruptwo.finalProject.service.ContainerService;
import com.gruptwo.finalProject.service.MultipleAnswerService;
import com.gruptwo.finalProject.service.QuestionService;
import com.gruptwo.finalProject.service.SurveyService;
import com.gruptwo.finalProject.service.UserService;





@Controller
public class WAppController {
	
	
	@Autowired
	private QuestionService serviceQuest;

	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private UserRepository userRep;

	@Autowired
	private SurveyService serviceSurv;

	@Autowired
	private ContainerService serviceCont;
	
	@Autowired
	private MultipleAnswerService serviceMult;

	@GetMapping("/")
	public String inicio() {
		return"index";
	}

	@GetMapping("/adminPage")
	public String adminPage() {
		return "adminPage";
	}

	//----------------------------------------------//User Methods-------------------------------------------------//
	//Show form Login User
	@RequestMapping(value="/loginUser")
	public String showFormUserRegister(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "loginUser";
	}

	

	// Show the form in order to update a given user
	@RequestMapping(value="/showFormUser/{id}")
	public String showFormUserUpdate(Model model , @PathVariable(name="id") Integer id) {
		User user = serviceUser.getUserById(id);
		model.addAttribute("user", user);
		return "updateUser";
	}

	//Makes the update of the user
	@RequestMapping(value="/updateUser")
	public String updateUser(@ModelAttribute("user") User user) {
		serviceUser.updateUser(user);
		return "redirect:/listUsers";
	}

	//makes the delete of the user
	@GetMapping(value="deleteUser/{id}")
	public String deleteUser(@PathVariable(name="id") Integer id) {		
		serviceUser.deleteUser(id);		
		return "redirect:/listUsers";
	}

	//List Users
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		List<User> listU = serviceUser.userList();
		model.addAttribute("users", listU);
		return"listUsers";
	}
	
	@PostMapping("/loginUser")
	public String logUser(Model model,  @ModelAttribute("user") User user, @ModelAttribute("survey") Survey survey) {
		model.addAttribute("user", user);
		model.addAttribute("survey", survey);
		serviceUser.saveUser(user);

		userRep.save(new User(user.getIdUser(), user.getName(), user.getSurname(), user.getAge(), new Survey(survey.getIdSurvey() ,survey.getTitle(),survey.getDescription())));
		
		return "redirect:userSurveyview";
		
	}
	
	//Se genera un objeto de user para el logeo
	//Además al elegir el usuario una Survey, los datos de ésta pasan al html para, posteriormente, 
	//relacionar el idSurvey con el user
	@GetMapping("/userSurveyview/{id}")	
	public ModelAndView verDetalle(@PathVariable("id") Integer id, @ModelAttribute("user") ModelAndView model) {
		User newUser = new User();
		model.addObject("user", newUser);		
		Survey survey = serviceSurv.getSurveyById(id);	
		model.addObject("survey", survey);
		
		model.setViewName("loginUser");	
		return model;
	}
	
	
	
	//----------------------------------------------//Survey Methods-------------------------------------------------//
	//List Surveys
	@GetMapping("/viewSurvey")
	public String viewSurvey(Model model) {
		List<Survey> lista = serviceSurv.surveyList();

		model.addAttribute("surveys", lista);

		return"viewSurvey";
	}

	// listar las surveys para el user
	@GetMapping("/userSurveyview")
	public String userSurveyview(Model model) {
		List<Survey> lista = serviceSurv.surveyList();
		model.addAttribute("surveys", lista);
		return"userSurveyview";
	}

	// Show Survey Form in order to update 
	@RequestMapping(value="/showFormSurvey/{id}")
	public String showFormUserUpdatable(Model model , @PathVariable(name="id") Integer id) {
		Survey survey = serviceSurv.getSurveyById(id);
		model.addAttribute("survey", survey);
		return "updateSurvey";
	}

	//Update Survey 
	@RequestMapping(value="/updateSurvey")
	public String updateSurvey(@ModelAttribute("survey") Survey survey) {
		serviceSurv.updateSurvey(survey);
		return "redirect:/viewSurvey";
	}

	//Delete Survey 
	@GetMapping(value="deleteSurvey/{id}")
	public String deleteSurvey(@PathVariable(name="id") Integer id) {		
		serviceSurv.deleteSurvey(id);		
		return "redirect:/viewSurvey";
	}


	//Formulario crear una nueva survey
	@RequestMapping(value="/createSurvey")
	public String showFormNewSurv(Model model) {
		Survey newSurv = new Survey();
		model.addAttribute("survey", newSurv);
		return "createSurvey";
	}
	
	//Save Survey
//	@RequestMapping(value="/saveSurvey")
//	public String saveSurvey(@ModelAttribute("survey") Survey survey ) {
//		if(survey.getIdSurvey() != null) {
//			survey.setIdSurvey(0);
//		}
//		serviceSurv.saveSurvey(survey);
//		return "createContainer";  
//	}
	@RequestMapping(value = "/saveSurvey")
	public String saveSurvey(@ModelAttribute("survey") Survey survey) {
		if (survey.getIdSurvey() != null) {
			survey.setIdSurvey(0);
		}
		serviceSurv.saveSurvey(survey);
		return "redirect:/adminPage";
	}
	

	//----------------------------------------------//Container Methods-------------------------------------------------//
	
//	//Formulario crear un nuevo contenedor/
//	@RequestMapping(value="/createContainer")
//	public String showFormNewCont(Model model,@PathVariable(name="id") Integer id ) {
//		Container newCont = new Container();
//		model.addAttribute("container", newCont);
//		return "createContainer";
//	}

	//	// Show Survey Form in order to update 
	//		@RequestMapping(value="/createContainer/{id}")
	//		public String showFormNewCont(Model model , @PathVariable(name="id") Integer id) {
	//			Container container = serviceCont.getSurveyById(id);
	//			model.addAttribute("survey", survey);
	//			return "createContainer";
	//		}


	//Save Container
	@RequestMapping(value="/createContainer")
	public String createContainer(Model model) {
		Container newCon = new Container();
		model.addAttribute("container", newCon);
		return "createContainer";  
	}
	@PostMapping("/saveContainer")
	public String saveContainer(@ModelAttribute("container") Container container) {
		if (container.getIdContainer() != null) {
			container.setIdContainer(0);
		}
		
		serviceCont.saveContainer(container);
		return "redirect:/adminPage";
	}
		@GetMapping("/viewContainer")
		public String viewContainer(Model model) {
			List<Container> lista = serviceCont.containerList();
			model.addAttribute("container", lista);
			return"viewContainer";
		}

	@GetMapping("/viewSurveyContainers/{id}")
	public String viewSurveyContainers(Model model, @PathVariable(name="id") Integer id) {
		List<Question> listaQ = serviceQuest.questionList();
		model.addAttribute("questions", listaQ);
		List<Container> listaC = serviceCont.containerList();
		model.addAttribute("containers", listaC);
		return "viewSurveyContainers";
	}

	@GetMapping("/viewSurveyByUser/{id}")
	public String viewSurveyByUser(Model model, @PathVariable(name="id") Integer id) {
		User user = serviceUser.getUserById(id);		
		Set<Survey> set = user.getSurveys();		
		model.addAttribute("surveys", set);
		return "viewSurvey";
	}

	//----------------------------------------------//Question Methods-------------------------------------------------//

	
		@GetMapping("/questionList")
		public String listQuestionU(Model model) {
			List<Question> listQ = serviceQuest.questionList();
			model.addAttribute("questions", listQ);
			return"questionList";
		}
		@RequestMapping(value="/createQuestion" )
		public String createQuestion(Model model) {
			
			List<Container> listU = serviceCont.containerList();
			model.addAttribute("containers", listU);
			Question newQuest = new Question();
			model.addAttribute("question", newQuest);
			return "createQuestions";  
		}
		
		@PostMapping("/saveQuestion")
		public String saveQuestion(@ModelAttribute("question") Question question) {
			if (question.getIdQuestion() != null) {
				question.setIdQuestion(0);
			}	
			Container cont = new Container();
			cont.setIdContainer(question.getIdContainer());
			question.setContainer(cont);
			serviceQuest.saveQuestion(question);
			return "redirect:/adminPage";
		}
		
		//----------------------------------------------//Question with multiple answer Methods-------------------------------------------------//
		
		
		@GetMapping("/multipleanswerquestionList")
		public String listMultipleQuestionU(Model model) {
			List<Question> listQ = serviceQuest.questionList();
			model.addAttribute("questions", listQ);
			return"questionList";
		}
		@RequestMapping(value="/multipleAnswer" )
		public String createMultipleAnswerQuestion(Model model) {
			
			List<Container> listU = serviceCont.containerList();
			model.addAttribute("containers", listU);
			MultipleAnswer newQuest = new MultipleAnswer();
			model.addAttribute("question", newQuest);
			return "multipleAnswer";  
		}
		
		@PostMapping("/saveMultipleAnswerQuestion")
		public String saveMultipleAnswerQuestion(@ModelAttribute("question") MultipleAnswer mult) {
			if (mult.getIdMultiAnswer() != null) {
				mult.setIdMultiAnswer(0);
			}	
			Container cont = new Container();
			cont.setIdContainer(mult.getIdContainer());
			mult.setContainerMul(cont);
			serviceMult.saveMultipleA(mult);
			return "redirect:/adminPage";
		}
		
		


}//End class
