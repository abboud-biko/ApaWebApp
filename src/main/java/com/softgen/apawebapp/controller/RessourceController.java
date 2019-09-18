package com.softgen.apawebapp.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@Controller
@RequestMapping(value="/ressource")
public class RessourceController {

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
	
	@RequestMapping(value="/forestiere", method=RequestMethod.GET)
	public ModelAndView ressoucesForestiereList() {
		ModelAndView model = new ModelAndView("ressources/ressources_forestiere");
		List<RessourceForestiere> ressourceList = ressourceForestiereRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/marine", method=RequestMethod.GET)
	public ModelAndView ressoucesMarineList() {
		ModelAndView model = new ModelAndView("ressources/ressources_marine");
		List<RessourceMarine> ressourceList = ressourceMarineRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/faune", method=RequestMethod.GET)
	public ModelAndView ressoucesFauneList() {
		ModelAndView model = new ModelAndView("ressources/ressources_faune");
		List<RessourceFaune> ressourceList = ressourceFauneRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/alim-agri", method=RequestMethod.GET)
	public ModelAndView ressoucesAlimAgriList() {
		ModelAndView model = new ModelAndView("ressources/ressources_alim_agri");
		List<RessourceForestiere> ressourceList = ressourceForestiereRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	
	/** detail d'une ressource **/
	
	@RequestMapping(value="/forestiere/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceForestiereDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/ressource_forestiere_detail");
		RessourceForestiere ressourceDetail = ressourceForestiereRepository.findOne(id);
		List<Image> images = imageRepository.findByRessourceForestiere(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	@RequestMapping(value="/marine/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceMarineDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/ressource_marine_detail");
		RessourceMarine ressourceDetail = ressourceMarineRepository.findOne(id);
		List<Image> images = imageRepository.findByRessourceMarine(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	@RequestMapping(value="/faune/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceFauneDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/ressource_faune_detail");
		RessourceFaune ressourceDetail = ressourceFauneRepository.findOne(id);
		List<Image> images = imageRepository.findByRessourceFaune(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	@RequestMapping(value="/alim-agri/{id}", method=RequestMethod.GET)
	public ModelAndView ressourceAlimAgriDetail(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView("ressources/ressource_alim_agri_detail");
		RessourceAlimAgri ressourceDetail = ressourceAlimAgriRepository.findOne(id);
		List<Image> images = imageRepository.findByRessourceAlimAgri(ressourceDetail);
		model.addObject("ressourceDetail", ressourceDetail);
		model.addObject("images", images);
		return model;
	}
	
	// ########################
	//		ADMINISTRATION
	// ########################
	
	/** liste des ressources **/
	
	@RequestMapping(value="/administration/forestiere", method=RequestMethod.GET)
	public ModelAndView adminRessoucesForestiereList() {
		ModelAndView model = new ModelAndView("ressources_administration/admin_ressources_forestiere");
		List<RessourceForestiere> ressourceList = ressourceForestiereRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/administration/marine", method=RequestMethod.GET)
	public ModelAndView adminRessoucesMarineList() {
		ModelAndView model = new ModelAndView("ressources_administration/admin_ressourcs_marine");
		List<RessourceMarine> ressourceList = ressourceMarineRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/administration/faune", method=RequestMethod.GET)
	public ModelAndView adminRessoucesFauneList() {
		ModelAndView model = new ModelAndView("ressources_administration/admin_ressources_faune");
		List<RessourceFaune> ressourceList = ressourceFauneRepository.findAll();
		model.addObject("ressourceList", ressourceList);	 
		return model;
	}
	
	@RequestMapping(value="/administration/alim-agri", method=RequestMethod.GET)
	public ModelAndView adminRessoucesAlimAgriList() {
		ModelAndView model = new ModelAndView("ressources_administration/admin_ressources_alim_agri");
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
		model.setViewName("ressource_forestiere_form");
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
		model.setViewName("ressources_administration/ressource_forestiere_form");
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
		return new ModelAndView("redirect:/ressource/administration/forestiere");
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
		
		return new ModelAndView("redirect:/ressource/administration/forestiere");
	}
	
	@RequestMapping(value="/administration/marine/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceMarine(@PathVariable("id") long id) {
		ressourceMarineRepository.delete(id);	  
		
		return new ModelAndView("redirect:/ressource/administration/marine");
	}
	
	@RequestMapping(value="/administration/faune/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceFaune(@PathVariable("id") long id) {
		ressourceFauneRepository.delete(id);	  
		
		return new ModelAndView("redirect:/ressource/administration/faune");
	}
	
	@RequestMapping(value="/administration/alim-agri/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRessourceAlimAgri(@PathVariable("id") long id) {
		ressourceAlimAgriRepository.delete(id);	  
		
		return new ModelAndView("redirect:/ressource/administration/alim-agri");
	}
	
}