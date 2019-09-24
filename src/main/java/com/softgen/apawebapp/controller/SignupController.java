package com.softgen.apawebapp.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.User;
import com.softgen.apawebapp.repository.UserRepository;


@Controller
public class SignupController {
	@Autowired
    private UserRepository userRepository;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("signup");
		User user = new User();
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView CreateUser(HttpSession session,@ModelAttribute("user") User user)
    {
		ModelAndView model = new ModelAndView();
       
     User userExists = userRepository.findByEmail(user.getEmail());
     if(userExists == null)
     {
         userRepository.save(user);
         session.setAttribute("user", user);
         session.setAttribute("loggedin", "true");
         
         model.addObject("user", user);
         model.setViewName("redirect:/accueil");
         return model;
     }
     else {
         model.addObject("errorSignup", "Ce email existe deja");
         model.setViewName("signup");
         User userSignup = new User();
 		 model.addObject("user", userSignup);
         return model;
     }

    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		User user = new User();
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkUser(HttpSession session,@ModelAttribute("user") User userToCheck)
    {
		ModelAndView model = new ModelAndView();
     User userExists = userRepository.findByEmail(userToCheck.getEmail());
     if(userExists != null)
     {
    	 if (userExists.getPassword().equals(userToCheck.getPassword())) {
	         User user = new User(userExists.getNom(),userExists.getPrenom(),userExists.getEmail(), userExists.getPassword());
	         session.setAttribute("user", user);
	         
	         model.addObject("user", user);
	         model.setViewName("redirect:/accueil");
	         return model;
    	 } else {
    		 model.addObject("errorLogin", "Le mot de passe est incorrect");
    		 model.setViewName("login");
             return model;
    	 }
     }
     else {
         model.addObject("errorLogin", "Le Compte n'existe pas");
         model.setViewName("login");
         User userLogin = new User();
 		 model.addObject("user", userLogin);
         return model;
     }

    }
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session,@ModelAttribute("user") User user) {
		session.removeAttribute("loggedin");
		ModelAndView model = new ModelAndView("login");
		model.addObject("user",user);
		return model;
    }
	
	

}
