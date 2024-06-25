package com.example.mobile.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.mobile.common.ApiResponse;
import com.example.mobile.common.JsonToken;
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
		
		if(user.getPassword()==null||user.getPassword().isEmpty()) {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setData("No Data Found");
			apiResponse.setMessage("Bad Request");
		}else {
			apiResponse.setStatus(HttpStatus.OK.value());
			userRepo.save(user);
			String token = JsonToken.generateJwt(user);
			Map<String, Object> data= new HashMap<>();
			data.put("Access Token ", token);
			apiResponse.setData(data);
		}
		return apiResponse;
	}

	@Override
	public ApiResponse login(LoginRequestDto loginRequest) {	
		ApiResponse apiResponse= new ApiResponse();
		User user = userRepo.findOneByEmailIdPassword(loginRequest.getEmailId(),
				loginRequest.getPassword());
		if(user==null) {
			apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			apiResponse.setData("No Data Found");
			apiResponse.setMessage("Bad Request");
		}else {
			apiResponse.setStatus(HttpStatus.OK.value());
			String token = JsonToken.generateJwt(user);
			Map<String, Object> data= new HashMap<>();
			data.put("Access Token ", token);
			apiResponse.setData(data);
		}
		
		return apiResponse;
	}

}
