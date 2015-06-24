package com.ninja_squad.geektic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.ConsultationDao;

@RestController
@Transactional
@RequestMapping("/Consultation")
public class ConsultationService {
	
	@Autowired
	private ConsultationDao daoConsultation;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public int getGeekCountHistory(@PathVariable int id) {
		return daoConsultation.findCountGeekHistoryById(id);
	}
}
