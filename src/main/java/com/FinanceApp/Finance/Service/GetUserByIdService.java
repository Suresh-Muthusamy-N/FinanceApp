package com.FinanceApp.Finance.Service;

import java.util.Optional;
import java.util.UUID;

import com.FinanceApp.Finance.Entity.UserEntity;

public interface GetUserByIdService {

	Optional<UserEntity> getUserById(UUID id);
}
