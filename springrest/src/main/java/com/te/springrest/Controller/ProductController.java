package com.te.springrest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springrest.beans.Product;
import com.te.springrest.beans.ProductResponse;
import com.te.springrest.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping(path= "/get",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse getProduct( int id) {
		Product p=service.getProduct(id);
		ProductResponse pr=new ProductResponse();
		
		if(p!=null) {
			pr.setStatusCode(200);
			pr.setMsg("Product Got Successfullyy");
			pr.setProduct(p);
		}
		return pr;
	}
	
	@PostMapping(path="/add",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse addProductResponse(@RequestBody Product prod) {
		ProductResponse pr=new ProductResponse();
		if(service.addProduct(prod)) {
			pr.setStatusCode(200);
			pr.setMsg("Added Successfullyyy");
		}
		else {
			pr.setStatusCode(500);
			pr.setMsg("Not Added Successfullyyy");
		}
		return pr;
	}
	
	@DeleteMapping(path="/delete/{id}",produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public ProductResponse delete(@PathVariable(name = "id")int id) {
		ProductResponse pr=new ProductResponse();
		if(service.delete(id)) {
			pr.setStatusCode(200);
			pr.setMsg(id+" Deleted Successfully");
		}
		
		return pr;
			
		}
	

}
