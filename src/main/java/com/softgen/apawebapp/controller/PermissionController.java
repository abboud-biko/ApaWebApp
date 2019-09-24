package com.softgen.apawebapp.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softgen.apawebapp.model.Role;
import com.softgen.apawebapp.repository.RoleRepository;

@Controller
public class PermissionController {
	@Autowired
    private RoleRepository roleRepository;
	
 
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public String role() {

		return "role";
	}
	
	@RequestMapping(value = "/role", method = RequestMethod.POST)
    public String CreateRole(ModelMap model, @RequestParam String role, @RequestParam String permissions)
    {
       
        
    	 Role role1 = new Role(role,permissions); 
         roleRepository.save(role1);
         model.addAttribute("role", role1);
         return "redirect:/";
     }
    

}
