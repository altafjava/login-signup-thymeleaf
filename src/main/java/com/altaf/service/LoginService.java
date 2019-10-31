package com.altaf.service;

import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altaf.dto.LoginDTO;
import com.altaf.dto.SignupDTO;
import com.altaf.model.Customer;
import com.altaf.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public void signup(SignupDTO signupDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(signupDTO, customer);
		Date date = new Date();
		customer.setCreatedDate(date);
		customer.setUpdatedDate(date);
		Customer c = loginRepository.save(customer);
		System.out.println(c);
	}

	public boolean login(LoginDTO loginDTO) {
		Customer customer = loginRepository.findByMobileOrEmail(loginDTO.getUsername(), loginDTO.getUsername());
		System.out.println("customer=" + customer);
		if (customer != null) {
			if (loginDTO.getPassword().equals(customer.getPassword())) {
				System.err.println("success password");
				return true;
			}
		}
		System.err.println("invalid password");
		return false;
	}
}
