package com.welyab.tutorials.restful.service;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import com.welyab.tutorials.restful.Customer;
import com.welyab.tutorials.restful.repository.CustomerRepository;

@RequestScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
	return customerRepository.listCustomers();
    }

    public Customer get(String customerCode) {
	Preconditions.checkNotNull(customerCode, "Parameter customerCode cannot be null");
	return customerRepository.findByCode(customerCode);
    }

    public void removeCustomer(String customerCode) {
	Preconditions.checkNotNull(customerCode, "Parameter customerCode cannot be null");

	customerRepository.delete(customerCode);
    }

    public void update(Customer customer) {
	Preconditions.checkNotNull(customer, "Parameter customer cannot be null");

	if (StringUtils.isBlank(customer.getCode())) {
	    throw new IllegalArgumentException("The customer code cannot be blank");
	}

	if (StringUtils.isBlank(customer.getName())) {
	    throw new IllegalArgumentException("Customer name cannot be blank");
	}

	if (StringUtils.isBlank(customer.getEmail())) {
	    throw new IllegalArgumentException("Customer email cannot be null");
	}

	customerRepository.update(customer);
    }

    public void addCostumer(Customer customer) {
	Preconditions.checkNotNull(customer, "Parameter customer cannot be null");

	if (StringUtils.isNotBlank(customer.getCode())) {
	    throw new IllegalArgumentException("In order to save a new customer, the code can't be already set");
	}

	if (StringUtils.isBlank(customer.getName())) {
	    throw new IllegalArgumentException("Customer name cannot be blank");
	}

	if (StringUtils.isBlank(customer.getEmail())) {
	    throw new IllegalArgumentException("Customer email cannot be null");
	}

	customer.setCode(UUID.randomUUID().toString());
	customerRepository.save(customer);
    }
}
