package com.FinanceApp.Finance.Entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")

public class UserEntity {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id", nullable = false, updatable = false)
	    private UUID id;

	    @Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Column(name = "password", nullable = false)
	    private String password;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "account_type", nullable = false)
	    private com.FinanceApp.Finance.Dto.RegistrationDto.AccountType accountType;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt = LocalDateTime.now();

	    @Column(name = "mobile_number", nullable = false)
	    private String mobileNumber;

	    @Column(name = "mobile_verified")
	    private boolean mobileVerified;

	    @Column(name = "email_verified")
	    private boolean emailVerified;

	    @Column(name = "is_active")
	    private boolean isActive = true;

	    @Column(name = "last_login")
	    private LocalDateTime lastLogin;

	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	        updatedAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }
	    
	    public enum AccountType {
	        DEFAULT, PREMIUM, ADMIN
	    }
	    
	    
		public UserEntity(String name2, String email2, String password2,
				com.FinanceApp.Finance.Dto.RegistrationDto.AccountType accountType2, String mobileNumber2) {
			// TODO Auto-generated constructor stub
		}

		public UserEntity() {
			// TODO Auto-generated constructor stub
		}

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

		public void setAccountType(com.FinanceApp.Finance.Dto.RegistrationDto.AccountType accountType2) {
			this.accountType = accountType2;
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
