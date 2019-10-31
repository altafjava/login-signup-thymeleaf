package com.altaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.altaf.model.Customer;

@Repository
public interface LoginRepository extends CrudRepository<Customer, Long> {

	Customer findByMobileOrEmail(String mobile, String email);
}
