package com.zensar.olxadvertise.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.entity.AdvertiseDetails;
@Service
public interface OlxAdvertiseService {
	Advertise addAdvertise( Advertise ads, String username,  String password);
	Advertise getAdvertise( long postId, String username, String password);
	Advertise updateAdvertise( long id, Advertise advertise,String username, String password);
	List<Advertise> getAllAdvertise( String username,  String password);
	 boolean deleteAdvertise( long id,String username,  String password);
	 Advertise searchAdvertisementsByCriteria( String category, String toDate,Long index, String fromDate) ;
	 List<Advertise> searchAdvertise();
	 List<AdvertiseDetails> advertiseDetails( long id, String username,  String password);
}
