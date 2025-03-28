package com.FinanceApp.Finance.Service;

import com.FinanceApp.Finance.Dto.AuthResponseDto;
import com.FinanceApp.Finance.Dto.LoginDto;

public interface AuthService {

	AuthResponseDto login(LoginDto loginDto);
}
