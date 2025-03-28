package com.FinanceApp.Finance.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Entity.UserEntity;
import com.FinanceApp.Finance.Repository.RegistrationRepository;
import com.FinanceApp.Finance.Service.GetAllUserService;

@Service
public class GetAllUserServiceImpl implements GetAllUserService{
	
	private final RegistrationRepository registrationRepository;
	
	
	

	public GetAllUserServiceImpl(RegistrationRepository registrationRepository) {
		super();
		this.registrationRepository = registrationRepository;
	}




	public List<UserEntity> getAllUsers(){		
		
		return registrationRepository.findAll();
		
	}
}
