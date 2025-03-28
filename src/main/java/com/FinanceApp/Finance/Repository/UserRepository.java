package com.FinanceApp.Finance.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FinanceApp.Finance.Entity.UserEntity;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
	
	@Modifying
	@Query("UPDATE UserEntity u SET u.isActive = false WHERE u.id = :id")
	int softDeleteById(@Param("id") UUID id);
	
	// Spring Data JPA already provides a deleteById method
	void deleteUserById(UUID id);
	
}
