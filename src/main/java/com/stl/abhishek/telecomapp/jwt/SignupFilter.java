package com.stl.abhishek.telecomapp.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SignupFilter extends OncePerRequestFilter{
	
	@Autowired
	Signupjwt utils;
	
	@Autowired
	SignupDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String header=request.getHeader("Authorization");
		String user=null;
		String token=null;
		
		if(header !=null && header.contains("Bearer")) {
			 token=header.substring(6);
			 user=utils.getUsername(token);
		}
			if(user!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				SignupDetails details= (SignupDetails) service.loadUserByUsername(user);
				
				if(utils.ValidToken(token, details)) {
					UsernamePasswordAuthenticationToken usertoken=new UsernamePasswordAuthenticationToken(
							details,null,details.getAuthorities());
					usertoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usertoken);
				}
			}
			
		
		filterChain.doFilter(request, response);
		
	}

}
