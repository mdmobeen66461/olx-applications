package com.zensar.olxadvertise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertise.entity.UserEntity;
import com.zensar.olxadvertise.repository.UserRepostiory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepostiory userRepostiory;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserEntity> userEntities=userRepostiory.findByUsername(username);
		
		// TODO Auto-generated method stub
		if(userEntities==null||userEntities.size()==0) {
			throw new UsernameNotFoundException(username);
		}
		
		UserEntity userEntity=userEntities.get(0);
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(userEntity.getRoles()));
		return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
		
		
	}
	
	
	

}
