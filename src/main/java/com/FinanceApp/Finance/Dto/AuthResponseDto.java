package com.FinanceApp.Finance.Dto;

public class AuthResponseDto {

//	private String name;
    private String email;
    private String password;
//    private String mobileNumber;
//    private String accountType;
	
    
    public AuthResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public AuthResponseDto(String name, String email, String password, String mobileNumber, String accountType) {
//		super();
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.mobileNumber = mobileNumber;
//		this.accountType = accountType;
//	}


    public AuthResponseDto(String email, String password) {
    	super();
    	this.email = email;
    	this.password = password;
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


	@Override
	public String toString() {
		return "AuthResponseDto [email=" + email + ", password=" + password + "]";
	}

    
	
   
	
}
