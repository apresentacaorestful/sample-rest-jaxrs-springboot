package com.welyab.tutorials.restful.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.welyab.tutorials.restful.Customer;

public class CustomerDao extends Dao<String, Customer> {

    @Inject
    private EntityManager entityManager;

    protected CustomerDao() {
	super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
	return entityManager;
    }

    public List<Customer> findAll() {
	return getEntityManager()
		.createQuery(
			"from Customer",
			Customer.class
		).getResultList();
    }
}
