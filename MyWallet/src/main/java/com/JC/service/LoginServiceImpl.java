package com.JC.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JC.exceptions.LoginException;
import com.JC.model.CurrentUserSession;
import com.JC.model.Customer;
import com.JC.model.UserLogin;
import com.JC.repository.CurrentSessionRepo;
import com.JC.repository.CustomerRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	
	/*-------------------------------------------   Login   --------------------------------------------------*/

	@Override
	public String login(UserLogin userLogin) throws LoginException {
		
        List<Customer> customer= customerRepo.findCustomerByMobile(userLogin.getMobileNumber());
		
		Customer existingCustomer = customer.get(0);
		
		if(existingCustomer == null) {
			throw new LoginException("Invalid MobileNumber!");
		}
		
		
		
		Optional<CurrentUserSession> optional =  currentSessionRepo.findByUserId(existingCustomer.getCustomerId());
		
		if(optional.isPresent()) {
			
			throw new LoginException("User Already Exists in the System.");
			
		}
		
		if(existingCustomer.getPin().equals(userLogin.getPin())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			currentSessionRepo.save(currentUserSession);

			return currentUserSession.toString();
		}

		throw new LoginException("Wrong Pin");
		
	}

	
	/*-------------------------------------   Logout   ----------------------------------------*/

	@Override
	public String logout(String key) throws LoginException {
		
        CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			throw new LoginException("Invalid Unique userId (Session Key).");
			
		}
		
		currentSessionRepo.delete(currentUserSession);
		
		return "Logged Out Successfully!";
	}

}
