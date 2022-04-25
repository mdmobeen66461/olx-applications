package com.zensar.olxmaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmaster.entity.Category;
import com.zensar.olxmaster.entity.Status;
import com.zensar.olxmaster.service.OlxMasterService;


@RestController
//@RequestMapping(value="/advertise",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value="/advertise")
public class MyController {
	@Autowired
	private OlxMasterService olxMasterService;
	
	@GetMapping(value="/category",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public List<Category> getAllAdvertisementCategories() {
		return olxMasterService.getAllAdvertisementCategories();
	}
	
	@GetMapping(value="/status",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public List<Status> getAllAdvertisementStatus(){
		return olxMasterService.getAllAdvertisementStatus();
	}
	

}
