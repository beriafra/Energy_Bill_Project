package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.customer.Customer;
import com.example.demo.repos.CustomerRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class CustomerRepoTest {

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
//	@Test
//	public void testCreateUser() {
//		Customer customer = new Customer();
//		customer.setCustomer_id("nuri@student.le.ac.uk");
//		customer.setPassword_hash("password");
//		customer.setAddress("27 Common");
//		customer.setBedroom_num(2);
//		customer.setProperty_type("Detached");
//		customer.setType("customer");
//
//		Customer savedCustomer = repo.save(customer);
//		Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getCustomer_id());
//		assertThat(existCustomer.getCustomer_id()).isEqualTo(customer.getCustomer_id());
//
//	}
	
//	@Test
//	public void testByCustomerID() {
//		String CustomerID = "kaan@pic.com";
//
//		Customer customer = repo.findByCustomerID(CustomerID);
//		assertThat(customer).isNotNull();
//
//	}
	
}
