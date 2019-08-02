package sample.di.business.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import sample.di.business.domain.Product;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    
    @Value("#{msgProperties['errors.datanotfound.customer']}")
    private String message;
    
    public String getMessage() {
    	return message;
    }
    
    @Value("#{msgProperties}")
    private Map<String, String> messageProperties;
    
    public Map<String, String> getMessageProperties() {
    	return messageProperties;
    }

	public void addProduct(Product product) {
		productDao.addProduct(product);

	}

	public Product findByProductName(String name) {
		 return productDao.findByProductName(name);
	}
}