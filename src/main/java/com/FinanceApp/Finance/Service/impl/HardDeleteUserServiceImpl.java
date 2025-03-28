package com.FinanceApp.Finance.Service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Repository.UserRepository;
import com.FinanceApp.Finance.Service.HardDeleteUserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class HardDeleteUserServiceImpl implements HardDeleteUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public void deleteUserById(UUID id) {
		// TODO Auto-generated method stub
		if(userRepository.existsById(id)) {
			userRepository.deleteUserById(id);
		}
		else {
			throw new EntityNotFoundException("User not found with the ID : "+ id);
		}
		
		
	}

}
