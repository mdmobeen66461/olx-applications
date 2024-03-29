package com.zensar.olxmaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxmaster.entity.Category;
import com.zensar.olxmaster.entity.Status;
import com.zensar.olxmaster.repository.CategoryRepository;
import com.zensar.olxmaster.repository.StatusRepository;

@Service
public class OlxMasterServiceImpl implements OlxMasterService{
	
	/*static List<Category> categories= new ArrayList<Category>();
	static List<Status> status=new ArrayList<Status>();
	
	static {
		categories.add(new Category(1L, "Furniture"));
		categories.add(new Category(2L, "Cars"));
		categories.add(new Category(3L, "Mobiles"));
		categories.add(new Category(4L, "Real Estate"));
		categories.add(new Category(5L, "Sports"));
	}
	
	static {
		status.add(new Status(1L, "OPEN"));
		status.add(new Status(2L, "CLOSED"));
	}
*/
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Override
	public List<Category> getAllAdvertisementCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Status> getAllAdvertisementStatus() {
		return statusRepository.findAll();
	}

}
