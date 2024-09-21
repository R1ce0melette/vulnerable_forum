package edu.deakin.sit218.examgeneration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.deakin.sit218.examgeneration.entity.User;
import edu.deakin.sit218.examgeneration.entity.UserDAO;
import edu.deakin.sit218.examgeneration.entity.UserDAOImpl;

@Controller
@Service
public class QuestionAnswerController {
//	@Autowired
//    private UserDAO userDAO;
	@GetMapping("/sqli")
	public String showSQLi(){
		return "sqli";
	}
	
	@GetMapping("/postsqli")
	public String postSQLi(@RequestParam("username") String username, 
		@RequestParam("password") String password,Model model, HttpServletRequest request) {
		UserDAO userdao = new UserDAOImpl();
		if(userdao.areCredentialsCorrect(username, password)) {
			model.addAttribute("username", userdao.retrieveUserByID(1).getUsername());
			return "sqli";
		} else {
			return "access-denied";
		}
		//Secure SQL below
		//model.addAttribute("username", userDAO.retrieveUserByID(1).getUsername());
		//return "sqli";
	}
}