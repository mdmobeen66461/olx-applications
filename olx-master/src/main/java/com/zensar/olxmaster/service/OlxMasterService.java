package com.zensar.olxmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxmaster.entity.Category;
import com.zensar.olxmaster.entity.Status;


public interface OlxMasterService {
	List<Category> getAllAdvertisementCategories();
	List<Status> getAllAdvertisementStatus();
}
