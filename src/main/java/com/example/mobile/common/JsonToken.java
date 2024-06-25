package com.example.mobile.common;

import com.example.mobile.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JsonToken {
	
	private static String secret = "This_is_secret";

	private static long experyDuration = 60 * 60;

	public static String generateJwt(User user) {

		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + experyDuration * 10;

		Claims claims = Jwts.claims().setIssuer(String.valueOf(user.getId()));

		claims.put("name", user.getName());
		claims.put("emailId", user.getEmailId());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public void verify(String authentication) throws Exception{
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authentication);
		}catch (Exception e){
			throw new Exception();
		}
	}
	
	

}
