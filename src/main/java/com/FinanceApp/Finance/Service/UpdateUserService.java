package com.FinanceApp.Finance.Service;

import java.util.Optional;
import java.util.UUID;

import com.FinanceApp.Finance.Dto.RegistrationDto;
import com.FinanceApp.Finance.Entity.UserEntity;

public interface UpdateUserService {

	Optional<UserEntity> getUserToUpdateById(UUID id);
	UserEntity updateUser(UUID id, RegistrationDto registrationDto);
}
