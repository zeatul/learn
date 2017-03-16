package com.hawk.utility.example.jsr303.example1;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestValidator {
	
	public static void main(String[] args){
		String orderId = "1";
	    String customer = "1";
	    String email = "1";
	    String address = "1";
	    String status = "1";
	    String productName = "1";
	    String productPrice = "1";
	    
	    Order order = new Order();
	    
	    order.setOrderId(orderId);
	    order.setCustomer(customer);
	    order.setEmail(email);
	    order.setAddress(address);
	    order.setStatus(status);
	    order.setCreateDate(new Date());
	    Product product = new Product();
	    product.setProductName(productName);
	    if(productPrice != null && productPrice.length() > 0)
	        product.setPrice(Float.valueOf(productPrice));
	    order.setProduct(product);
	    
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();
	    Set<ConstraintViolation<Order>> violations = validator.validate(order);
	    
	    if(violations.size() == 0){
	    	
	    }else{
	    	 StringBuilder buf = new StringBuilder();
	    	 ResourceBundle bundle = ResourceBundle.getBundle("messages");
	    	 for(ConstraintViolation<Order> violation: violations) {
	             buf.append("-" + bundle.getString(violation.getPropertyPath().toString()));
	             buf.append(violation.getMessage() + "<BR>\n");
	          }
	    	 System.out.println(buf.toString());
	    }
	}

}
