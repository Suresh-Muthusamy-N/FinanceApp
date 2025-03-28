package com.FinanceApp.Finance.Service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Dto.RegistrationDto;
import com.FinanceApp.Finance.Entity.UserEntity;
import com.FinanceApp.Finance.Repository.RegistrationRepository;
import com.FinanceApp.Finance.Service.UpdateUserService;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {

	private final RegistrationRepository registrationRepository;
	
	
	public UpdateUserServiceImpl(RegistrationRepository registrationRepository) {
		super();
		this.registrationRepository = registrationRepository;
	}

	@Override
	public Optional<UserEntity> getUserToUpdateById(UUID id) {
		// TODO Auto-generated method stub
		return registrationRepository.findById(id);
	}

	@Override
	public UserEntity updateUser(UUID id, RegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		Optional<UserEntity> existingUser = registrationRepository.findById(id);
		if(existingUser.isPresent()) {
			UserEntity user = existingUser.get();
			user.setName(registrationDto.getName());
			user.setEmail(registrationDto.getEmail());
			user.setPassword(registrationDto.getPassword());
			user.setAccountType(registrationDto.getAccountType());
			user.setMobileNumber(registrationDto.getMobileNumber());
			user.setMobileVerified(registrationDto.isMobileVerified());
			user.setEmailVerified(registrationDto.isEmailVerified());
			user.setActive(registrationDto.isActive());
			user.setLastLogin(registrationDto.getLastLogin());
			
			return registrationRepository.save(user);
		}
		else {
			throw new RuntimeException("User not found with id:  "+ id);
		}
		
	}

}
