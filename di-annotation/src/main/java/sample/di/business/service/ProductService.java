package sample.di.business.service;

import java.util.Map;

import sample.di.business.domain.Product;

public interface ProductService {
		void addProduct(Product product);
	    Product findByProductName(String name);
	    
	    String getMessage();
	    Map<String, String> getMessageProperties();
}
