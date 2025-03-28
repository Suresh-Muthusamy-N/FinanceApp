package com.FinanceApp.Finance.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.FinanceApp.Finance.Entity.UserEntity;

@EnableJpaRepositories
@Repository
public interface RegistrationRepository extends JpaRepository<UserEntity, UUID>{
	
	//Method to get all users
	List <UserEntity> findAll();
	
	//Method to get an user by id
	Optional <UserEntity> findById(UUID id);

}
