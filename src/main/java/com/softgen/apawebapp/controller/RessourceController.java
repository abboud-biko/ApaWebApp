package com.softgen.apawebapp.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.softgen.apawebapp.model.Image;
import com.softgen.apawebapp.model.RessourceAlimAgri;
import com.softgen.apawebapp.model.RessourceFaune;
import com.softgen.apawebapp.model.RessourceForestiere;
import com.softgen.apawebapp.model.RessourceMarine;
import com.softgen.apawebapp.repository.ImageRepository;
import com.softgen.apawebapp.repository.RessourceAlimAgriRepository;
import com.softgen.apawebapp.repository.RessourceFauneRepository;
import com.softgen.apawebapp.repository.RessourceForestiereRepository;
import com.softgen.apawebapp.repository.RessourceMarineRepository;


@RestController
public class ressourceController {

	@Autowired
    private RessourceForestiereRepository ressourceForestiereRepository;
	@Autowired
    private RessourceFauneRepository ressourceFauneRepository;
	@Autowired
    private RessourceAlimAgriRepository ressourceAlimAgriRepository;
	@Autowired
    private RessourceMarineRepository ressourceMarineRepository;
	@Autowired
    private ImageRepository imageRepository;
	
	/** liste des ressources **/
	
	@RequestMapping(value="/ressource/forestiere", method=RequestMethod.GET)
	public ModelAndView ressoucesForestiereList() {
		ModelAndView model = new ModelAndView("lot04_01forest");
		List<RessourceForestiere> ressourceList = ressourceForestiereRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/ressource/marine", method=RequestMethod.GET)
	public ModelAndView ressoucesMarineList() {
		ModelAndView model = new ModelAndView("lot04_02marine");
		List<RessourceMarine> ressourceList = ressourceMarineRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/ressource/faune", method=RequestMethod.GET)
	public ModelAndView ressoucesFauneList() {
		ModelAndView model = new ModelAndView("lot04_04wildlife");
		List<RessourceFaune> ressourceList = ressourceFauneRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/ressource/alim-agri", method=RequestMethod.GET)
	public ModelAndView ressoucesAlimAgriList() {
		ModelAndView model = new ModelAndView("lot04_03agriculture");
		List<RessourceAlimAgri> ressourceList = ressourceAlimAgriRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	
	/** detail d'une ressource **/
	
	@RequestMapping(value="/ressource/forestiere/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceForestiereDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("lot04_01forest_details");
		RessourceForestiere ressourceDetail = ressourceForestiereRepository.findById(id);
		List<Image> images = imageRepository.findByRessourceForestiere(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	@RequestMapping(value="/ressource/marine/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceMarineDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("lot04_02marine_details");
		RessourceMarine ressourceDetail = ressourceMarineRepository.findById(id);
		List<Image> images = imageRepository.findByRessourceMarine(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	@RequestMapping(value="/ressource/faune/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceFauneDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("lot04_04wildlife_details");
		RessourceFaune ressourceDetail = ressourceFauneRepository.findById(id);
		List<Image> images = imageRepository.findByRessourceFaune(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	@RequestMapping(value="/ressource/alim-agri/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceAlimAgriDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("lot04_03agriculture_details");
		RessourceAlimAgri ressourceDetail = ressourceAlimAgriRepository.findById(id);
		List<Image> images = imageRepository.findByRessourceAlimAgri(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	// ########################
	//		ADMINISTRATION
	// ########################
	
	/** Home page **/
	
	@RequestMapping(value="/administration", method=RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView("index");	 
		return model;
	}
	
	
	/** liste des ressources **/
	
	@RequestMapping(value="/administration/forestiere", method=RequestMethod.GET)
	public ModelAndView adminRessoucesForestiereList() {
		ModelAndView model = new ModelAndView("forest-table");
		List<RessourceForestiere> ressourceList = ressourceForestiereRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/administration/marine", method=RequestMethod.GET)
	public ModelAndView adminRessoucesMarineList() {
		ModelAndView model = new ModelAndView("marin-table");
		List<RessourceMarine> ressourceList = ressourceMarineRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/administration/faune", method=RequestMethod.GET)
	public ModelAndView adminRessoucesFauneList() {
		ModelAndView model = new ModelAndView("wildlife-table");
		List<RessourceFaune> ressourceList = ressourceFauneRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/administration/alim-agri", method=RequestMethod.GET)
	public ModelAndView adminRessoucesAlimAgriList() {
		ModelAndView model = new ModelAndView("agricultur-table");
		List<RessourceForestiere> ressourceList = ressourceForestiereRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	/** ajouter une ressource **/
	
	@RequestMapping(value="/administration/forestiere/add", method=RequestMethod.GET)
	public ModelAndView addRessourceForestiere() {
		ModelAndView model = new ModelAndView();
		RessourceForestiere ressourceForestiere = new RessourceForestiere();
		model.addObject("ressourceForestiere", ressourceForestiere);
		model.setViewName("form");
		return model;
	}
	
	@RequestMapping(value="/administration/marine/add", method=RequestMethod.GET)
	public ModelAndView addRessourceMarine() {
		ModelAndView model = new ModelAndView();
		RessourceMarine ressourceMarine = new RessourceMarine();
		model.addObject("ressourceMarine", ressourceMarine);
		model.setViewName("ressources_administration/ressource_marine_form");
		return model;
	}
	
	@RequestMapping(value="/administration/faune/add", method=RequestMethod.GET)
	public ModelAndView addRessourceFaune() {
		ModelAndView model = new ModelAndView();
		RessourceFaune ressourceFaune = new RessourceFaune();
		model.addObject("resourceFaune", ressourceFaune);
		model.setViewName("ressources_administration/ressource_faune_form");
		return model;
	}
	
	@RequestMapping(value="/administration/alim-agri/add", method=RequestMethod.GET)
	public ModelAndView addRessourceAlimAgri() {
		ModelAndView model = new ModelAndView();
		RessourceAlimAgri ressourceAlimAgri = new RessourceAlimAgri();
		model.addObject("resourceAlimAgri", ressourceAlimAgri);
		model.setViewName("ressources_administration/ressource_alim_agri_form");
		return model;
	}
	
	/** modifier une ressource **/
	
	@RequestMapping(value="/administration/forestiere/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRessourceForestiere(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView(); 
		RessourceForestiere ressourceForestiere = ressourceForestiereRepository.getOne(id);
		model.addObject("ressourceForestiere", ressourceForestiere);
		model.setViewName("form");
		return model;
	}
	
	@RequestMapping(value="/administration/marine/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRessourceMarine(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView(); 
		RessourceMarine ressourceMarine = ressourceMarineRepository.getOne(id);
		model.addObject("ressourceMarine", ressourceMarine);
		model.setViewName("ressources_administration/ressource_marine_form");
		return model;
	}
	
	@RequestMapping(value="/administration/faune/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRessourceFaune(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView(); 
		RessourceFaune ressourceFaune = ressourceFauneRepository.getOne(id);
		model.addObject("ressourceFaune", ressourceFaune);
		model.setViewName("ressources_administration/ressource_faune_form");
		return model;
	}
	
	@RequestMapping(value="/administration/alim-agri/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editRessourceAlimAgri(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView(); 
		RessourceAlimAgri ressourceAlimAgri = ressourceAlimAgriRepository.getOne(id);
		model.addObject("ressourceAlimAgri", ressourceAlimAgri);
		model.setViewName("ressources_administration/ressource_alim_agri_form");
		return model;
	}
	
	/** sauvegarder une ressource **/
 
	@RequestMapping(value="/administration/forestiere/save", method=RequestMethod.POST)
	public ModelAndView saveRessourceForestiere(@ModelAttribute("ressourceForistere") RessourceForestiere ressourceForestiere) {
		ressourceForestiereRepository.save(ressourceForestiere);
		return new ModelAndView("redirect:/administration/forestiere");
	}
	
	@RequestMapping(value="/administration/marine/save", method=RequestMethod.POST)
	public ModelAndView saveRessourceMarine(@ModelAttribute("ressourceMarine") RessourceMarine ressourceMarine) {
		ressourceMarineRepository.save(ressourceMarine);
		return new ModelAndView("redirect:/ressource/administration/marine");
	}
	
	@RequestMapping(value="/administration/faune/save", method=RequestMethod.POST)
	public ModelAndView saveRessourceFaune(@ModelAttribute("ressourceFaune") RessourceFaune ressourceFaune) {
		ressourceFauneRepository.save(ressourceFaune);
		return new ModelAndView("redirect:/ressource/administration/faune");
	}
	
	@RequestMapping(value="/administration/alim-agri/save", method=RequestMethod.POST)
	public ModelAndView saveRessourceAlimAgri(@ModelAttribute("ressourceAlimAgri") RessourceAlimAgri ressourceAlimAgri) {
		ressourceAlimAgriRepository.save(ressourceAlimAgri);
		return new ModelAndView("redirect:/ressource/administration/alim-agri");
	}
 
	/** supprimer une ressource **/
	
	@RequestMapping(value="/administration/forestiere/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceForestiere(@PathVariable("id") long id) {
		ressourceForestiereRepository.delete(id);	  
		
		return new ModelAndView("redirect:/administration/forestiere");
	}
	
	@RequestMapping(value="/administration/marine/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceMarine(@PathVariable("id") long id) {
		ressourceMarineRepository.deleteById(id);	  
		
		return new ModelAndView("redirect:/ressource/administration/marine");
	}
	
	@RequestMapping(value="/administration/faune/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceFaune(@PathVariable("id") long id) {
		ressourceFauneRepository.deleteById(id);	  
		
		return new ModelAndView("redirect:/ressource/administration/faune");
	}
	
	@RequestMapping(value="/administration/alim-agri/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceAlimAgri(@PathVariable("id") long id) {
		ressourceAlimAgriRepository.deleteById(id);	  
		
		return new ModelAndView("redirect:/ressource/administration/alim-agri");
	}
	
}