package com.example.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobile.common.ApiResponse;
import com.example.mobile.dto.LoginRequestDto;
import com.example.mobile.dto.SignUpRequestDto;
import com.example.mobile.service.LoginService;

@RestController
@RequestMapping("/rest")
public class LoginController {

	@Autowired
	LoginService loginSservice;
	
	
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
		ApiResponse apiResponse = loginSservice.signUp(signUpRequestDto);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);				 
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody LoginRequestDto loginRequest) {
		ApiResponse apiResponse = loginSservice.login(loginRequest);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);				 
	}
	
	
}
