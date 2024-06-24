package com.example.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobile.common.ApiResponse;
import com.example.mobile.dto.LoginRequestDto;
import com.example.mobile.dto.SignUpRequestDto;
import com.example.mobile.entity.User;
import com.example.mobile.repository.UserRepository;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public ApiResponse signUp(SignUpRequestDto signUpRequestDto) {
		ApiResponse apiResponse = new ApiResponse();
		User user = new User();
		user.setName(signUpRequestDto.getName());
		user.setGender(signUpRequestDto.getGender());
		user.setEmailId(signUpRequestDto.getEmailId());
		user.setPassword(signUpRequestDto.getPassword());
		userRepo.save(user);
		return apiResponse;
	}

	@Override
	public ApiResponse login(LoginRequestDto loginRequest) {
		
		ApiResponse apiResponse= new ApiResponse();
		
		User user = userRepo.findOneByEmailIdIgnoreCaseAndPasword(LoginRequestDto.getEmailId(),LoginRequestDto.getPassword());
		
		return apiResponse;
	}

}
