package com.softgen.apawebapp.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.softgen.apawebapp.model.Localisation;
import com.softgen.apawebapp.model.RessourceAlimAgri;
import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.RessourceForestiere;
import com.softgen.apawebapp.model.RessourceMarine;
import com.softgen.apawebapp.repository.LocalisationRepository;
import com.softgen.apawebapp.repository.RessourceAlimAgriRepository;
import com.softgen.apawebapp.repository.RessourceFauneRepository;
import com.softgen.apawebapp.repository.RessourceForestiereRepository;
import com.softgen.apawebapp.repository.RessourceMarineRepository;


@Controller

public class localisationController {

	@Autowired
    private RessourceForestiereRepository ressourceForestiereRepository;
	@Autowired
    private RessourceFauneRepository ressourceFauneRepository;
	@Autowired
    private RessourceAlimAgriRepository ressourceAlimAgriRepository;
	@Autowired
    private RessourceMarineRepository ressourceMarineRepository;
	@Autowired
    private LocalisationRepository localisationRepository;
	
	@RequestMapping(value="/ressource/forestiere/{id}/localisations", method=RequestMethod.GET)
	public ModelAndView ressourceForestierePartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/localisations");
		RessourceForestiere ressourceDetail = ressourceForestiereRepository.findById(id);
		List<Localisation> localisations = localisationRepository.findByRessourceForestiere(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("localisations", localisations);
		return model;
	}
	
	@RequestMapping(value="/ressource/marine/{id}/localisations", method=RequestMethod.GET)
	public ModelAndView ressourceMarinePartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/localisations");
		RessourceMarine ressourceDetail = ressourceMarineRepository.findById(id);
		List<Localisation> localisations = localisationRepository.findByRessourceMarine(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("localisations", localisations);
		return model;
	}
	
	@RequestMapping(value="/ressource/faune/{id}/localisations", method=RequestMethod.GET)
	public ModelAndView ressourceFaunePartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/localisations");
		RessourceFaune ressourceDetail = ressourceFauneRepository.findById(id);
		List<Localisation> localisations = localisationRepository.findByRessourceFaune(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("localisations", localisations);
		return model;
	}
	
	@RequestMapping(value="/ressource/alim-agri/{id}/localisations", method=RequestMethod.GET)
	public ModelAndView ressourceAlimAgriPartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/localisations");
		RessourceAlimAgri ressourceDetail = ressourceAlimAgriRepository.findById(id);
		List<Localisation> localisations = localisationRepository.findByRessourceAlimAgri(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("localisations", localisations);
		return model;
	}
	
	// ########################
	//		ADMINISTRATION
	// ########################
	
	/** liste des localisaitons **/
	
	@RequestMapping(value="/localisations/administration/{ressourceType}/{id}", method=RequestMethod.GET)
	public ModelAndView adminLocalisationsList(@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		ModelAndView model = new ModelAndView("ressources_administration/admin_localisations");
		List<Localisation> localisations = null;
		switch (ressourceType) { 
        case "forestiere": 
        	RessourceForestiere ressourceForestiere = ressourceForestiereRepository.findById(id);
        	localisations = localisationRepository.findByRessourceForestiere(ressourceForestiere);
            break; 
        case "marine": 
        	RessourceMarine ressourceMarine = ressourceMarineRepository.findById(id);
        	localisations = localisationRepository.findByRessourceMarine(ressourceMarine);
            break; 
        case "faune": 
        	RessourceFaune ressourceFaune = ressourceFauneRepository.findById(id);
        	localisations = localisationRepository.findByRessourceFaune(ressourceFaune);
            break; 
        case "alim-agri": 
        	RessourceAlimAgri ressourceAlimAgri = ressourceAlimAgriRepository.findById(id);
        	localisations = localisationRepository.findByRessourceAlimAgri(ressourceAlimAgri);
            break;  
        }
		model.addObject("localisations", localisations);
		model.addObject("ressourceType",ressourceType);
		model.addObject("id", id);
		return model;
	}
	
	/** ajouter une localisation **/
	
	@RequestMapping(value="/localisations/administration/{ressourceType}/{id}/add", method=RequestMethod.GET)
	public ModelAndView addLocalisation(@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		ModelAndView model = new ModelAndView();
		Localisation localisation = new Localisation();
		model.addObject("localisation", localisation);
		model.addObject("ressourceType", ressourceType);
		model.addObject("id", id);
		model.setViewName("ressources_administration/localisation_form");
		return model;
	}
	
	/** sauvegarder une localisation **/
	 
	@RequestMapping(value="/localisations/administration/{ressourceType}/{id}/save", method=RequestMethod.POST)
	public ModelAndView saveLocaliasition(@ModelAttribute("localisation") Localisation localisation,@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		localisationRepository.save(localisation);
		ModelAndView model = new ModelAndView();
		switch (ressourceType) { 
        case "forestiere": 
        	RessourceForestiere ressourceForestiere = ressourceForestiereRepository.findById(id);
        	localisation.setRessourceForestiere(ressourceForestiere);
        	model.setViewName("redirect:/localisations/administration/forestiere/"+id);
            break; 
        case "marine": 
        	RessourceMarine ressourceMarine = ressourceMarineRepository.findById(id);
        	localisation.setRessourceMarine(ressourceMarine);
        	model.setViewName("redirect:/localisations/administration/marine/"+id);
            break;
        case "faune": 
        	RessourceFaune ressourceFaune = ressourceFauneRepository.findById(id);
        	localisation.setRessourceFaune(ressourceFaune);
        	model.setViewName("redirect:/localisations/administration/faune/"+id);
            break; 
        case "alim-agri": 
        	RessourceAlimAgri ressourceAlimAgri = ressourceAlimAgriRepository.findById(id);
        	localisation.setRessourceAlimAgri(ressourceAlimAgri);
        	model.setViewName("redirect:/localisations/administration/alim-agri/"+id);
            break;  
        }
		return model;
	}
	
	/** supprimer une localisation **/
	 
	@RequestMapping(value="/localisations/administration/{ressourceType}/{id}/delete/{locId}", method=RequestMethod.GET)
	public ModelAndView deleteLocalisaition(@PathVariable("locId") long locId,@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		localisationRepository.deleteById(locId);
		ModelAndView model = new ModelAndView();
		switch (ressourceType) { 
        case "forestiere": 
        	model.setViewName("redirect:/localisations/administration/forestiere/"+id);
            break; 
        case "marine": 
        	model.setViewName("redirect:/localisations/administration/marine/"+id);
            break;
        case "faune": 
        	model.setViewName("redirect:/localisations/administration/faune/"+id);
            break; 
        case "alim-agri": 
        	model.setViewName("redirect:/localisations/administration/alim-agri/"+id);
            break;  
        }
		return model;
	}

}