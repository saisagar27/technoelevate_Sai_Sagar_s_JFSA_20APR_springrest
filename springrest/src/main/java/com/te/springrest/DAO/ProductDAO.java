package com.te.springrest.DAO;

import com.te.springrest.beans.Product;
import com.te.springrest.beans.ProductResponse;

public interface ProductDAO {
	
	public Product getProduct(int id);
	
	public boolean addProduct(Product p);
	
	public boolean delete(int id);

}
