package com.FinanceApp.Finance.Service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Entity.UserEntity;
import com.FinanceApp.Finance.Repository.RegistrationRepository;
import com.FinanceApp.Finance.Service.GetUserByIdService;

@Service
public class GetUserByIdServiceImpl implements GetUserByIdService {
	
	private final RegistrationRepository registrationRepository;
	

	public GetUserByIdServiceImpl(RegistrationRepository registrationRepository) {
		super();
		this.registrationRepository = registrationRepository;
	}




	@Override
	public Optional<UserEntity> getUserById(UUID id) {
		// TODO Auto-generated method stub
		return registrationRepository.findById(id);
	}

}
