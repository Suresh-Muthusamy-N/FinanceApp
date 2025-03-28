package com.FinanceApp.Finance.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.FinanceApp.Finance.Entity.UserEntity;

@EnableJpaRepositories
@Repository
public interface LoginRepository extends JpaRepository<UserEntity, UUID>{

	UserEntity findOneByEmailIgnoreCaseAndPassword(String emailId, String password);
}
