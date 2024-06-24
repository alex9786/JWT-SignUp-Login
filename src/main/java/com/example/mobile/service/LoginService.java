package com.example.mobile.service;

import com.example.mobile.common.ApiResponse;
import com.example.mobile.dto.LoginRequestDto;
import com.example.mobile.dto.SignUpRequestDto;

public interface LoginService {

	ApiResponse signUp(SignUpRequestDto signUpRequestDto);

	ApiResponse login(LoginRequestDto loginRequest);

	

}
