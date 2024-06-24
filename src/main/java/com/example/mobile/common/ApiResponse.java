package com.example.mobile.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ApiResponse {

	private Integer status;
    private String message;
    
    public ApiResponse() {
    	 this.status = HttpStatus.OK.value();
    	 this.message="success";
    }

    
}
