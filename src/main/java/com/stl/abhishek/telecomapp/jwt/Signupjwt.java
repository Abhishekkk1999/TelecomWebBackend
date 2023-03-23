package com.stl.abhishek.telecomapp.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Signupjwt implements Serializable{
	

	
	
	private static final long serialVersionUID = 1L;
	final  String  key="VFb0qJ1LRg_4ujbZoRMXnVkUgiuKq5KxWqNdbKq_G9Vvz-S1zZa9LPxtHWKa64zDl2ofkT8F6jBt_K4riU-fPg";
     final  long exptime= 1000 * 60 * 60 * 10;
	public String generatetoken(SignupDetails details) {
		Map<String, Object> claims=new HashMap<>();
		
		return Jwts.builder().setClaims(claims)
				.setSubject(details.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+exptime))
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
	}
	
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
	}
	
	
	public Boolean ValidToken(String token, SignupDetails details) {
		Boolean validation=Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody()
				.getExpiration().before(new Date(System.currentTimeMillis()));
	
		return ((details.getUsername()).equals(getUsername(token))
				&& !validation);
	}
}
