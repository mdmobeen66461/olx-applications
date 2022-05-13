package com.zensar.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.zensar.spring.beans.Product;
import com.zensar.spring.repository.ProductRepository;


public class ProductServiceImpl1 implements ProductService {

	
	private ProductRepository repositoryImpl;

	/*
	 * public ProductServiceImpl1(ProductRepository repository) { System.out.
	 * println("inside public ProductServiceImpl1(ProductRepository repository) !!!"
	 * ); this.repositoryImpl=repository; }
	 */
	public int insertProduct(Product product) {

		return repositoryImpl.insertProduct(product);
	}
	
	public boolean deleteProduct(int productId) {
		return repositoryImpl.deleteProduct(productId);
		
	}


	public int updateProduct(Product product) {
		return repositoryImpl.updateProduct(product);
		
		
	}
	
	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}

	public void setRepositoryImpl(ProductRepository repositoryImpl) {
		System.out.println("inside public void setRepositoryImpl(ProductRepository repositoryImpl !!)");
		this.repositoryImpl = repositoryImpl;
	}

	@PostConstruct
	public void myInit() {
		System.out.println("inside myInit() !!!");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println(" inside myDestroy()");
	}

	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return repositoryImpl.listProducts();
	}


	

}
