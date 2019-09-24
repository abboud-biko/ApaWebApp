package com.softgen.apawebapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softgen.apawebapp.model.User;


@Controller
public class AccueilController {
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public ModelAndView homePage(HttpSession session,@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("accueil");
		model.addObject("user", user);
		return model;
	}
}
