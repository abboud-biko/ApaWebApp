package com.softgen.apawebapp.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.softgen.apawebapp.model.PartieUtilise;
import com.softgen.apawebapp.model.RessourceAlimAgri;
import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.RessourceForestiere;
import com.softgen.apawebapp.model.RessourceMarine;
import com.softgen.apawebapp.repository.PartieUtiliseRepository;
import com.softgen.apawebapp.repository.RessourceAlimAgriRepository;
import com.softgen.apawebapp.repository.RessourceFauneRepository;
import com.softgen.apawebapp.repository.RessourceForestiereRepository;
import com.softgen.apawebapp.repository.RessourceMarineRepository;

@Controller
@RequestMapping
public class PartieUtiliseController {

	@Autowired
    private RessourceForestiereRepository ressourceForestiereRepository;
	@Autowired
    private RessourceFauneRepository ressourceFauneRepository;
	@Autowired
    private RessourceAlimAgriRepository ressourceAlimAgriRepository;
	@Autowired
    private RessourceMarineRepository ressourceMarineRepository;
	@Autowired
    private PartieUtiliseRepository partieUtiliseRepository;
	
	@RequestMapping(value="/ressource/forestiere/{id}/parties-utilisees", method=RequestMethod.GET)
	public ModelAndView ressourceForestierePartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/parties_utilisees_forestiere");
		RessourceForestiere ressourceDetail = ressourceForestiereRepository.findOne(id);
		List<PartieUtilise> partiesUtilisees = partieUtiliseRepository.findByRessourceForestiere(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("partiesUtilisees", partiesUtilisees);
		return model;
	}
	
	@RequestMapping(value="/ressource/marine/{id}/parties-utilisees", method=RequestMethod.GET)
	public ModelAndView ressourceMarinePartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/parties_utilisees_marine");
		RessourceMarine ressourceDetail = ressourceMarineRepository.findOne(id);
		List<PartieUtilise> partiesUtilisees = partieUtiliseRepository.findByRessourceMarine(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("partiesUtilisees", partiesUtilisees);
		return model;
	}
	
	@RequestMapping(value="/ressource/faune/{id}/parties-utilisees", method=RequestMethod.GET)
	public ModelAndView ressourceFaunePartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/parties_utilisees_faune");
		RessourceFaune ressourceDetail = ressourceFauneRepository.findOne(id);
		List<PartieUtilise> partiesUtilisees = partieUtiliseRepository.findByRessourceFaune(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("partiesUtilisees", partiesUtilisees);
		return model;
	}
	
	@RequestMapping(value="/ressource/alim-agri/{id}/parties-utilisees", method=RequestMethod.GET)
	public ModelAndView ressourceAlimAgriPartiesUtilise(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/parties_utilisees_alim_agri");
		RessourceAlimAgri ressourceDetail = ressourceAlimAgriRepository.findOne(id);
		List<PartieUtilise> partiesUtilisees = partieUtiliseRepository.findByRessourceAlimAgri(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("partiesUtilisees", partiesUtilisees);
		return model;
	}
	

	// ########################
	//		ADMINISTRATION
	// ########################
	
	/** liste des parties utilisees **/
	
	@RequestMapping(value="/parties-utilisees/administration/{ressourceType}/{id}", method=RequestMethod.GET)
	public ModelAndView adminPartiesUtiliseesList(@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		ModelAndView model = new ModelAndView("ressources_administration/admin_parties_utilisees");
		List<PartieUtilise> partiesUtilisees = null;
		switch (ressourceType) { 
        case "forestiere": 
        	RessourceForestiere ressourceForestiere = ressourceForestiereRepository.findOne(id);
        	partiesUtilisees = partieUtiliseRepository.findByRessourceForestiere(ressourceForestiere);
            break; 
        case "marine": 
        	RessourceMarine ressourceMarine = ressourceMarineRepository.findOne(id);
        	partiesUtilisees = partieUtiliseRepository.findByRessourceMarine(ressourceMarine);
            break; 
        case "faune": 
        	RessourceFaune ressourceFaune = ressourceFauneRepository.findOne(id);
        	partiesUtilisees = partieUtiliseRepository.findByRessourceFaune(ressourceFaune);
            break; 
        case "alim-agri": 
        	RessourceAlimAgri ressourceAlimAgri = ressourceAlimAgriRepository.findOne(id);
        	partiesUtilisees = partieUtiliseRepository.findByRessourceAlimAgri(ressourceAlimAgri);
            break;  
        }
		model.addObject("partiesUtilisees", partiesUtilisees);
		model.addObject("ressourceType",ressourceType);
		model.addObject("id", id);
		
		return model;
	}
	
	/** ajouter une partie utilise **/
	
	@RequestMapping(value="/parties-utilisees/administration/{ressourceType}/{id}/add", method=RequestMethod.GET)
	public ModelAndView addPartieUtilise(@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		ModelAndView model = new ModelAndView();
		PartieUtilise partieUtilise = new PartieUtilise();
		model.addObject("partieUtilise", partieUtilise);
		model.addObject("ressourceType", ressourceType);
		model.addObject("id", id);
		model.setViewName("ressources_administration/partie_utilise_form");
		return model;
	}
	
	/** modifier une partie utilise **/
	@RequestMapping(value="/parties-utilisees/administration/{ressourceType}/{id}/edit/{partieId}", method=RequestMethod.GET)
	public ModelAndView editPartieUtilise(@PathVariable("partieId") long partieId,@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		ModelAndView model = new ModelAndView(); 
		PartieUtilise partieUtilise = partieUtiliseRepository.getOne(id);
		model.addObject("partieUtilise", partieUtilise);
		model.setViewName("ressources_administration/partie_utilise_form");
		return model;
	}
	
	/** sauvegarder une partie utilise **/
	 
	@RequestMapping(value="/parties-utilisees/administration/{ressourceType}/{id}/save", method=RequestMethod.POST)
	public ModelAndView savePartieUtilise(@ModelAttribute("partieUtilise") PartieUtilise partieUtilise,@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		
		ModelAndView model = new ModelAndView();
		switch (ressourceType) { 
        case "forestiere": 
        	RessourceForestiere ressourceForestiere = ressourceForestiereRepository.findOne(id);
        	partieUtilise.setRessourceForestiere(ressourceForestiere);
        	model.setViewName("redirect:/parties-utilisees/administration/forestiere/"+id);
            break; 
        case "marine": 
        	RessourceMarine ressourceMarine = ressourceMarineRepository.findOne(id);
        	partieUtilise.setRessourceMarine(ressourceMarine);
        	model.setViewName("redirect:/parties-utilisees/administration/marine/"+id);
            break;
        case "faune":
        	RessourceFaune ressourceFaune = ressourceFauneRepository.findOne(id);
        	partieUtilise.setRessourceFaune(ressourceFaune);
        	model.setViewName("redirect:/parties-utilisees/administration/faune/"+id);
            break; 
        case "alim-agri":
        	RessourceAlimAgri ressourceAlimAgri = ressourceAlimAgriRepository.findOne(id);
        	partieUtilise.setRessourceAlimAgri(ressourceAlimAgri);
        	model.setViewName("redirect:/parties-utilisees/administration/alim-agri/"+id);
            break;  
        }
		partieUtiliseRepository.save(partieUtilise);
		return model;
	}
	
	/** supprimer une partie utilise **/
	 
	@RequestMapping(value="/parties-utilisees/administration/{ressourceType}/{id}/delete/{partieId}", method=RequestMethod.GET)
	public ModelAndView deleteLocalisaition(@PathVariable("partieId") long partieId,@PathVariable("id") long id,@PathVariable("ressourceType") String ressourceType) {
		partieUtiliseRepository.delete(partieId);
		ModelAndView model = new ModelAndView();
		switch (ressourceType) { 
        case "forestiere": 
        	model.setViewName("redirect:/parties-utilisees/administration/forestiere/"+id);
            break; 
        case "marine": 
        	model.setViewName("redirect:/parties-utilisees/administration/marine/"+id);
            break;
        case "faune": 
        	model.setViewName("redirect:/parties-utilisees/administration/faune/"+id);
            break; 
        case "alim-agri": 
        	model.setViewName("redirect:/parties-utilisees/administration/alim-agri/"+id);
            break;  
        }
		return model;
	}
	
}