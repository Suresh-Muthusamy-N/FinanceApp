package com.FinanceApp.Finance.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinanceApp.Finance.Dto.AuthResponseDto;
import com.FinanceApp.Finance.Dto.LoginDto;
import com.FinanceApp.Finance.Entity.UserEntity;
import com.FinanceApp.Finance.Repository.LoginRepository;
import com.FinanceApp.Finance.Service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private LoginRepository loginRepository ;
//	private PasswordEncoder passwordEncoder;
//	private JwtUtil jwtUtil;
	
	
//	
//	public AuthServiceImpl(LoginRepository loginRepository) {
//		super();
//		this.loginRepository = loginRepository;
////		this.passwordEncoder = passwordEncoder;
////		this.jwtUtil = jwtUtil;
//	}



	@Override
	public AuthResponseDto login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		System.out.println(loginDto.getEmail());
		UserEntity user = loginRepository.findOneByEmailIgnoreCaseAndPassword(loginDto.getEmail(), loginDto.getPassword());
		
		if(user == null) {
			return null;
		}
		else {
			AuthResponseDto response = new AuthResponseDto();
			response.setEmail(loginDto.getEmail());
			response.setPassword(loginDto.getPassword());
			return response;
		}
		
		
		
	//	
//		if ((loginDto.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//		
//		String token = jwtUtil.generateToken(user.getEmail());
//		return new AuthResponseDto(token, "Login successful");
		
	}

}
