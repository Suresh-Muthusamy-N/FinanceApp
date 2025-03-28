package com.FinanceApp.Finance.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FinanceApp.Finance.Dto.AuthResponseDto;
import com.FinanceApp.Finance.Dto.LoginDto;
import com.FinanceApp.Finance.Dto.RegistrationDto;
import com.FinanceApp.Finance.Entity.UserEntity;
import com.FinanceApp.Finance.Service.AuthService;
import com.FinanceApp.Finance.Service.GetAllUserService;
import com.FinanceApp.Finance.Service.GetUserByIdService;
import com.FinanceApp.Finance.Service.HardDeleteUserService;
import com.FinanceApp.Finance.Service.RegisterService;
import com.FinanceApp.Finance.Service.SoftDeleteUserService;
import com.FinanceApp.Finance.Service.UpdateUserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
	
	private RegisterService registerService;	
	@Autowired
	private AuthService authService;
	@Autowired
	private GetAllUserService getAllUserService;
	@Autowired
	private GetUserByIdService getUserByIdService;
	@Autowired
	private UpdateUserService updateUserService; 
	@Autowired
	SoftDeleteUserService softDeleteUserService;
	@Autowired
	HardDeleteUserService hardDeleteUserService;

	
	@Autowired
	public UserController(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}
	
	public UserController(AuthService authService) {
		super();
		this.authService = authService;
	}

	public UserController(GetAllUserService getAllUserService) {
		super();
		this.getAllUserService = getAllUserService;
	}
		
	public UserController(GetUserByIdService getUserByIdService) {
		super();
		this.getUserByIdService = getUserByIdService;
	}
	
	public UserController(UpdateUserService updateUserService) {
		super();
		this.updateUserService = updateUserService;
	}
	
	public UserController(SoftDeleteUserService softDeleteUserService) {
		super();
		this.softDeleteUserService = softDeleteUserService;
	}
	
	public UserController(HardDeleteUserService hardDeleteUserService) {
		super();
		this.hardDeleteUserService = hardDeleteUserService;
	}

	//Create User
	@PostMapping("/create")
	public ResponseEntity<RegistrationDto>createUser(@RequestBody RegistrationDto registrationdto){
		
		return new ResponseEntity<RegistrationDto>(registerService.registerUser(registrationdto)
				, HttpStatus.CREATED);
		
	}
	
	//Login User
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDto> loginUser(@RequestBody LoginDto loginDto){
		AuthResponseDto response =authService.login(loginDto);
		return ResponseEntity.ok(response);
						
	}
	
	
	//Get All Users
	@GetMapping("/allusers")
	public ResponseEntity<List<UserEntity>> getCompleteUsers(){
		
		List<UserEntity> users = getAllUserService.getAllUsers();
		return ResponseEntity.ok(users);
		
	}
	
	
	//Get user by ID
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserId(@PathVariable(name = "id") UUID id){
		Optional<UserEntity> user =getUserByIdService.getUserById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}else {
			return ResponseEntity.status(404).body("User not found");
		}		
		
	}
	
	//Update existing user by Id
	@PutMapping("/user/update/{id}")
	public ResponseEntity<?> updateExistingUser(@PathVariable(name = "id") UUID id, @RequestBody RegistrationDto  registrationDto){
		try {
			UserEntity updatedUser =updateUserService.updateUser(id, registrationDto);		
			return ResponseEntity.ok(updatedUser);
		}
		catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(404).body(e.getMessage());
		}
		
		
	}
	
	//Soft Delete the existing User.
	@DeleteMapping("/user/soft-delete/{id}")
	public ResponseEntity<String> softDeleteExistingUser(@PathVariable(name = "id") UUID id){
		try {
		
			softDeleteUserService.softDeleteUser(id);
			return ResponseEntity.ok("User successfully soft-deleted");
			
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
		
	}
	
	//Hard delete the Existing User.
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<String> hardDeleteUser(@PathVariable(name = "id") UUID id){
		try {
			hardDeleteUserService.deleteUserById(id);
			return ResponseEntity.ok("User Deleted Successfully");
		}
		catch(RuntimeException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
		
		
	}
	
}
