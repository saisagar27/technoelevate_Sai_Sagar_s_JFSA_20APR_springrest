package com.te.springrest.Controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springrest.beans.ProductResponse;
import com.te.springrest.exception.ProductException;

@RestControllerAdvice
public class ProductControllerAdvicer {
	
	@ExceptionHandler(ProductException.class)
	public ProductResponse handleException(ProductException exception) {
		
		ProductResponse pr=new ProductResponse();
		pr.setStatusCode(500);
		pr.setMsg(exception.getMessage());
		
		return pr;
	}

}
