package service;

import java.util.Collection;

import dao.CustomerRepository;
import exception.CustomerNotFoundException;
import model.Customer;

public class CustomerService {
	
	private final CustomerRepository repository;

	  public CustomerService(CustomerRepository repository) {
	    this.repository = repository;
	  }

	  public Customer findById(long id) {
	    return repository.findById(id)
	        .orElseThrow(CustomerNotFoundException::new);
	  }

	  public Collection<Customer> findCustomers() {
	    return repository.getCustomers();
	  }

	  public Customer updateCustomer(long id, Customer customer) {
	    if (repository.findById(id).isPresent()) {
	      repository.update(customer);
	    } else {
	      repository.add(customer);
	    }
	    return customer;
	  }

	  public Customer createCustomer(Customer customer) {
	    repository.add(customer);
	    return customer;
	  }

	  public void deleteCustomer(long id) {
	    repository.remove(id);
	  }

	}


