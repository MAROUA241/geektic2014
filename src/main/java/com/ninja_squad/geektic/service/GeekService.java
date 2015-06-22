package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.model.Geek;


	@RestController
	@Transactional
	@RequestMapping("/Geeks")
	public class GeekService {
  
		
	        @Autowired
	        private GeekDAO lesGeeks;
	        
	      
	        @RequestMapping(method = GET,value = "/{sexe}")
	        public List<Geek> getGeeks(@PathVariable char sexe)
	        {
	            List<Geek> MesGeeks = lesGeeks.getAllGeek(sexe);
	            return MesGeeks;
	        }
	}


