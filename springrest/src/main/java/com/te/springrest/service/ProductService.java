package com.te.springrest.service;

import com.te.springrest.beans.Product;
import com.te.springrest.beans.ProductResponse;

public interface ProductService {
	
	public Product getProduct(int id);
	
	public boolean addProduct(Product p);
	
	public boolean delete(int id);

}
