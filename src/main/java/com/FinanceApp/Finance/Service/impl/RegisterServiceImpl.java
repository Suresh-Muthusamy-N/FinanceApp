package com.FinanceApp.Finance.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Dto.RegistrationDto;
import com.FinanceApp.Finance.Entity.UserEntity;
import com.FinanceApp.Finance.Repository.RegistrationRepository;
import com.FinanceApp.Finance.Service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	
	private RegistrationRepository registrationRepository; 
	
	@Autowired
	public RegisterServiceImpl(RegistrationRepository registrationRepository) {
		this.registrationRepository =registrationRepository;
	}
	
	public RegistrationDto registerUser(RegistrationDto registerDto) {
		// TODO Auto-generated method stub
		
		//Convert DTO to entity
		
		System.out.println("haialone");
		UserEntity user = new UserEntity();
		user.setName(registerDto.getName());
		user.setEmail(registerDto.getEmail());
		user.setPassword(registerDto.getPassword());
		user.setMobileNumber(registerDto.getMobileNumber());
		user.setAccountType(registerDto.getAccountType());
		
		
		
		UserEntity newUser = registrationRepository.save(user);
 		
		
		//Convert Entity to DTO
		RegistrationDto registerResponse = new RegistrationDto();
		
		registerResponse.setId(newUser.getId());
		registerResponse.setName(newUser.getName());
		registerResponse.setEmail(newUser.getEmail());
		registerResponse.setAccountType(newUser.getAccountType());
		registerResponse.setMobileNumber(newUser.getMobileNumber());
		
		
		
		return registerResponse;
	}

}
