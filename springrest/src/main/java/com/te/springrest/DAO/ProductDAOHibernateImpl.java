package com.te.springrest.DAO;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import com.te.springrest.beans.Product;
import com.te.springrest.beans.ProductResponse;
import com.te.springrest.exception.ProductException;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO{


	@Override
	public Product getProduct(int id) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SpringDB");
		EntityManager em=emf.createEntityManager();
		
		Product p=em.find(Product.class, id);
		
		
		
		return p;
	}

	@Override
	public boolean addProduct(Product p) {
		
		boolean isAdded=false;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SpringDB");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		if(p!=null) {
		em.persist(p);
		isAdded=true;
		}
		et.commit();
		
		return isAdded;
	}

	@Override
	public boolean delete(int id) {
		boolean isDeleted=false;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SpringDB");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		try {
		et.begin();
		Product p=em.find(Product.class, id);
		em.remove(p);
		et.commit();
		isDeleted=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ProductException("Could not find "+id+" ,Please,Retry!!");
		}
		
		
		return isDeleted;
	}

}
