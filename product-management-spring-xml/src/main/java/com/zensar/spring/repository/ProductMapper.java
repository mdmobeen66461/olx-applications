package com.zensar.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.spring.beans.Product;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rows) throws SQLException {
		Product product = new Product();
		
		
		product.setProductId(rs.getInt("productId"));
		product.setProductCost(rs.getInt("productCost"));
		product.setProductName(rs.getString("productName"));
		return product;
		
		/*
		 * emp.setId(rs.getInt("empid")); emp.setAddress(rs.getString("empaddress"));
		 * emp.setAge(rs.getInt("empAge")); emp.setName(rs.getString("empname"));
		 * emp.setSalary(rs.getLong("salary"));
		 * 
		 * return emp;
		 */
	}

}
