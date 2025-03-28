package com.FinanceApp.Finance.Service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Repository.UserRepository;
import com.FinanceApp.Finance.Service.SoftDeleteUserService;

import jakarta.transaction.Transactional;

@Service
public class SoftDeleteUserServiceImpl implements SoftDeleteUserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public void softDeleteUser(UUID id) {
		// TODO Auto-generated method stub
		int updatedRows = userRepository.softDeleteById(id);
		if(updatedRows == 0) {
			throw new RuntimeException("User not found with ID :" + id);
		}
		
	}

}
