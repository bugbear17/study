package sample;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.di.business.domain.Product;
import sample.di.business.service.ProductService;

public class ProductSampleRun {

    public static void main(String[] args) {
        ProductSampleRun productSampleRun = new ProductSampleRun();
        productSampleRun.execute();
    }

    @SuppressWarnings("resource")
	public void execute() {
    	// BeanFactory는ApplicationContext에서 변경해도 괜찮습니다
        BeanFactory ctx = new ClassPathXmlApplicationContext(
                "/sample/config/applicationContext.xml");
        ProductService productService = ctx.getBean(ProductService.class);
        
        System.out.println("getMessage : " + productService.getMessage());
        
        Map<String, String> map = productService.getMessageProperties();
        
        for(Map.Entry<String, String> oneData : map.entrySet()) {
        	System.out.println("key = " + oneData.getKey() + " Value " + oneData.getValue());
        }
        
        productService.addProduct(new Product("공책", 100));

        Product product = productService.findByProductName("공책");
        System.out.println(product);

    }
}