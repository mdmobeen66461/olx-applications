package com.zensar.olxadvertise.controller;

import java.util.ArrayList;
import java.util.List;

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



@RestController

public class Controller {

	static List<Advertise> advertises = new ArrayList<Advertise>();
	static List<AdvertiseDetails> advertiseDetails=new ArrayList<AdvertiseDetails>();

	static {
		advertises.add(new Advertise(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"4/21/22", "4/21/22", "OPEN"));
	}
	
	static {
		advertiseDetails.add(new AdvertiseDetails(1L, "laptop sale", 54000, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"4/21/22", "4/21/22", "OPEN","Anand Kulkarni"));
	}

	@PostMapping(value="/advertise",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Advertise> addAdvertise(@RequestBody Advertise ads,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertises.add(ads);
			ads.setCategory("Electronic goods");
			ads.setUserName("anand");
			ads.setCreatedDate("4/21/22");
			ads.setModifiedDate("4/21/22");
			ads.setStatus("OPEN");
			return new ResponseEntity<Advertise>(ads, HttpStatus.CREATED);
		}

		return null;

	}
@GetMapping(value="/user/advertise/{postId}",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
public Advertise getAdvertise(@PathVariable long postId,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
	if (username.equals("anand") && password.equals("anand123")) {
		
		for(Advertise ads:advertises) {
			if(ads.getId()==postId) {
				return ads;
			}
			
		}
	}
		return null;
		
	}

	@PutMapping(value="/advertise/{id}",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Advertise updateAdvertise(@PathVariable long id, @RequestBody Advertise advertise,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			Advertise ads = getAdvertise(id, "anand", "anand123");
			ads.setTitle(advertise.getTitle());
			ads.setPrice(advertise.getPrice());
			ads.setDescription(advertise.getDescription());
			
			return ads;
		}

		return null;

	}
	
	@GetMapping(value="/user/advertise",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public List<Advertise> getAllAdvertise(@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
		return advertises;
		}
		
		return null;
	}
	
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteAdvertise(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
		for(Advertise ads:advertises) {
			if(ads.getId()==id) {
				advertises.remove(ads);
				
				return true;
			}
		}
			
		}
		return false;
	}
	
	@GetMapping(value="/advertise/search/{index}",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public Advertise searchAdvertisementsByCriteria(@PathVariable String category, String toDate,Long index, String fromDate) {
		for(Advertise ads:advertises) {
			if(ads.getId()==index||ads.getCategory().equals(category)||ads.getCreatedDate().equals(fromDate)||ads.getModifiedDate().equals(toDate)) {
				return ads;
			}
////			else if(ads.getCategory().equals(category)){
////				return ads;
//			}else if(ads.getCreatedDate().equals(fromDate)) {
//				return ads;
//			}else if(ads.getModifiedDate()==toDate) {
//				return ads;
//			}
			
		}
		return null;
	}
	
	@GetMapping(value="/advertise/search",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public List<Advertise> searchAdvertise() {
		
		return advertises;
		
	}
	@GetMapping(value="/advertise/{postId}",produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE})
	public List<AdvertiseDetails> advertiseDetails(@PathVariable("postId") long id,@RequestHeader("userName") String username, @RequestHeader("password") String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for(AdvertiseDetails ads:advertiseDetails) {
				if(ads.getId()==id) {
			
					return advertiseDetails;
				}
			}
		}
		return null;
		
	}

}
