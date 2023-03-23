package com.stl.abhishek.telecomapp.jwt;


import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.stl.abhishek.telecomapp.model.User;

@Component
public class SignupDetails implements UserDetails{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -1600006628772582378L;
    User mdl;
	
	

	public SignupDetails(User mdl) {
		super();
		this.mdl = mdl;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("user"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return mdl.getUserpwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return mdl.getPhone_no();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
