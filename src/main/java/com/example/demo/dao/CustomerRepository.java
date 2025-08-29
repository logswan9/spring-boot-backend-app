package com.example.demo.dao;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Iterable<Customer> findAll();
//
//    Customer findById(long id);
//
//    Customer save(Customer customer);

}
