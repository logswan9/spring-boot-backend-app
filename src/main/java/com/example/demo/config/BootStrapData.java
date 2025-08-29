package com.example.demo.config;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 1) {

            Customer customer1 = new Customer();
            customer1.setFirstName("Logan");
            customer1.setLastName("Swanson");
            customer1.setAddress("123 Test St");
            customer1.setPostal_code("11111");
            customer1.setPhone("(111)111-1111");
            Optional<Division> division1 = divisionRepository.findById(Long.valueOf("22"));
            customer1.setDivision(division1.get());

            Customer customer2 = new Customer();
            customer2.setFirstName("Linda");
            customer2.setLastName("Lindsey");
            customer2.setAddress("1149 Chipmunk Lane");
            customer2.setPostal_code("04401");
            customer2.setPhone("(222)222-2222");
            Optional<Division> division2 = divisionRepository.findById(Long.valueOf("18"));
            customer2.setDivision(division2.get());

            Customer customer3 = new Customer();
            customer3.setFirstName("Howard");
            customer3.setLastName("Medina");
            customer3.setAddress("3845 Adams Drive");
            customer3.setPostal_code("76903");
            customer3.setPhone("(333)333-3333");
            Optional<Division> division3 = divisionRepository.findById(Long.valueOf("42"));
            customer3.setDivision(division3.get());

            Customer customer4 = new Customer();
            customer4.setFirstName("Jeffrey");
            customer4.setLastName("Wheeler");
            customer4.setAddress("1382 Mahlon Street");
            customer4.setPostal_code("48219");
            customer4.setPhone("(444)444-4444");
            Optional<Division> division4 = divisionRepository.findById(Long.valueOf("21"));
            customer4.setDivision(division4.get());

            Customer customer5 = new Customer();
            customer5.setFirstName("John");
            customer5.setLastName("Johnson");
            customer5.setAddress("3530 Stonecoal Road");
            customer5.setPostal_code("43609");
            customer5.setPhone("(555)555-5555");
            Optional<Division> division5 = divisionRepository.findById(Long.valueOf("63"));
            customer5.setDivision(division5.get());

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            System.out.println("Sample Customers Added");


        }

    }
}
