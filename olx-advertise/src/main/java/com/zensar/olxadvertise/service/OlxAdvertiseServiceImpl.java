package com.zensar.olxadvertise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.entity.AdvertiseDetails;
@Service
public class OlxAdvertiseServiceImpl implements OlxAdvertiseService {
	
	
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

	@Override
	public Advertise addAdvertise(Advertise ads, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertises.add(ads);
			ads.setCategory("Electronic goods");
			ads.setUserName("anand");
			ads.setCreatedDate("4/21/22");
			ads.setModifiedDate("4/21/22");
			ads.setStatus("OPEN");
			return ads;
		}

		return null;
	}

	@Override
	public Advertise getAdvertise(long postId, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			
			for(Advertise ads:advertises) {
				if(ads.getId()==postId) {
					return ads;
				}
				
			}
		}
			return null;
	}

	@Override
	public Advertise updateAdvertise(long id, Advertise advertise, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			Advertise ads = getAdvertise(id, "anand", "anand123");
			ads.setTitle(advertise.getTitle());
			ads.setPrice(advertise.getPrice());
			ads.setDescription(advertise.getDescription());
			
			return ads;
		}

		return null;
	}

	@Override
	public List<Advertise> getAllAdvertise(String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			return advertises;
			}
			
			return null;
	}

	@Override
	public boolean deleteAdvertise(long id, String username, String password) {
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

	@Override
	public Advertise searchAdvertisementsByCriteria(String category, String toDate, Long index, String fromDate) {
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

	@Override
	public List<Advertise> searchAdvertise() {
		return advertises;
	}

	@Override
	public List<AdvertiseDetails> advertiseDetails(long id, String username, String password) {
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
