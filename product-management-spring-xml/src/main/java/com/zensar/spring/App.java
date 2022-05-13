package com.zensar.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		ProductService service = context.getBean("service", ProductService.class);
		String enteredValue = null;

		do {
			System.out.println("Enter your choice: ");
			System.out.println("1-Inserting new Product\n" +"2-Display Products\n"+ "3-Delete Product\n" + "4-Update Product\n");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				Product product = new Product(1, "Mobile", 20000);
				service.insertProduct(product);

				System.out.println("Product inserted successfullyyyyy !!!");
				break;
				
				
			case 2:
				
				System.out.println(service.listProducts());
				break;

			case 3:
				System.out.println("Enter Product  id ");
				int productid = sc.nextInt();
				if (productid == productid) {
					service.deleteProduct(productid);
					System.out.println("Product deleted successfullyyyyy !!!");
				}else {
					System.out.println("Enter Valid product Id");
				}

				break;
			case 4:
				service.updateProduct(new Product(4, "BMW", 2440000));
				System.out.println("Product updated successfullyyyyy !!!");

			}
			System.out.println("Do you want to continue (y/n): ");
			enteredValue = sc.next();

		} while (enteredValue.equalsIgnoreCase("y"));
		System.out.println("Thank you");

	}
}
