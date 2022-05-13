package com.zensar.spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private JdbcTemplate template;
	
	

	public ProductRepositoryImpl1() {

	}

	// insert

	public int insertProduct(Product product) {
		// createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return 1;
	}

	// delete

	public boolean deleteProduct(int productId) {
		String sql = "delete from product where productId= ?";

		return template.update(sql, productId) > 0;
	}

	// update

	public int updateProduct(Product product) {
		String sql = "update product set productName = ?, productCost = ? where productId=?";
		return template.update(sql, product.getProductName(), product.getProductCost(),product.getProductId());
		
	}

	public void createTable() {
		template.execute("create table product(productId int ,productName varchar(50),productCost int)");
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Product> listProducts() {
		String sql = "select * from product";
		List<Product> list = template.query(sql, new ProductMapper());
		return list;
	}

}
