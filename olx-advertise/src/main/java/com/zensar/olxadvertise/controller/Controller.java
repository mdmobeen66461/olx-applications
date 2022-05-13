package com.zensar.olxadvertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.entity.AdvertiseDetails;
import com.zensar.olxadvertise.service.OlxAdvertiseService;




@RestController
//@RequestMapping(produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class Controller {

	@Autowired
	private OlxAdvertiseService olxAdvertiseService;

	@PostMapping(value="/advertise")
	public ResponseEntity<Advertise> addAdvertise(@RequestBody Advertise ads,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		
		
		Advertise advertise =olxAdvertiseService.addAdvertise(ads, username, password);

    	return new ResponseEntity<Advertise>(advertise,HttpStatus.CREATED);
		
		

	}
@GetMapping(value="/user/advertise/{postId}")
public Advertise getAdvertise(@PathVariable long postId,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
	  return olxAdvertiseService.getAdvertise(postId, username, password);
		
	}

	@PutMapping(value="/advertise/{id}",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Advertise updateAdvertise(@PathVariable long id, @RequestBody Advertise advertise,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		return olxAdvertiseService.updateAdvertise(id, advertise, username, password);

	}
	
	@GetMapping(value="/user/advertise")
	public List<Advertise> getAllAdvertise(@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		return olxAdvertiseService.getAllAdvertise(username, password);
	}
	
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteAdvertise(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		return olxAdvertiseService.deleteAdvertise(id, username, password);
	}
	
	@GetMapping(value="/advertise/search/{index}")
	public Advertise searchAdvertisementsByCriteria(@PathVariable long index, String category, String toDate, String fromDate) {
		return olxAdvertiseService.searchAdvertisementsByCriteria(category, toDate, index, fromDate);
	}
	
	@GetMapping(value="/advertise/search")
	public List<Advertise> searchAdvertise() {
		
		return olxAdvertiseService.searchAdvertise();
		
	}
	@GetMapping(value="/advertise/{postId}")
	public List<AdvertiseDetails> advertiseDetails(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		
		
		return olxAdvertiseService.advertiseDetails(id, username, password);
	}

}
