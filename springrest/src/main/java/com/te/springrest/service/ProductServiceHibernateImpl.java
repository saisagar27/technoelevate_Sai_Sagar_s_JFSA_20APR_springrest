package com.te.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springrest.DAO.ProductDAO;
import com.te.springrest.beans.Product;
import com.te.springrest.beans.ProductResponse;

@Service
public class ProductServiceHibernateImpl implements ProductService{
	@Autowired
	private ProductDAO dao;

	@Override
	public Product getProduct(int id) {

		return dao.getProduct(id);
	}

	@Override
	public boolean addProduct(Product p) {
		if(p!=null) {
		return dao.addProduct(p);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		
		
		return dao.delete(id);
		
		
	}

}
