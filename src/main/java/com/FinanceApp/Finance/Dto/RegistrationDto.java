package com.FinanceApp.Finance.Dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.FinanceApp.Finance.Entity.UserEntity.AccountType;

import lombok.Data;

@Data
public class RegistrationDto {
	
	private UUID id;
	private String name;
	private String email;
	private String password;
	private com.FinanceApp.Finance.Dto.RegistrationDto.AccountType accountType;
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	private String mobileNumber;
	private boolean mobileVerified;
	private boolean emailVerified;
	private boolean isActive = true;
	private LocalDateTime lastLogin;
	
	
	public enum AccountType {
        DEFAULT, PREMIUM, ADMIN
    }

	
	
	
	// Constructor and its required fields for user creation

	public RegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RegistrationDto(String name, String email, String password, com.FinanceApp.Finance.Dto.RegistrationDto.AccountType accountType, String mobileNumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.accountType = accountType;
		this.mobileNumber = mobileNumber;
	}

	
	
public RegistrationDto(UUID id, String name, String email, String password, AccountType accountType,
			LocalDateTime createdAt, LocalDateTime updatedAt, String mobileNumber, boolean mobileVerified,
			boolean emailVerified, boolean isActive, LocalDateTime lastLogin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.accountType = accountType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.mobileNumber = mobileNumber;
		this.mobileVerified = mobileVerified;
		this.emailVerified = emailVerified;
		this.isActive = isActive;
		this.lastLogin = lastLogin;
	}

//
//	public RegistrationDto(UUID id2, String name2, String email2,
//			com.FinanceApp.Finance.Entity.UserEntity.AccountType accountType2, String mobileNumber2) {
//		// TODO Auto-generated constructor stub
//	}


	

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public com.FinanceApp.Finance.Dto.RegistrationDto.AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(com.FinanceApp.Finance.Dto.RegistrationDto.AccountType accountType) {
		this.accountType = accountType;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public boolean isMobileVerified() {
		return mobileVerified;
	}


	public void setMobileVerified(boolean mobileVerified) {
		this.mobileVerified = mobileVerified;
	}


	public boolean isEmailVerified() {
		return emailVerified;
	}


	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public LocalDateTime getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
}
