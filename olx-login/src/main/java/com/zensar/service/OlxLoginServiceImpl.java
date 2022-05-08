package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.User;
import com.zensar.repository.UserRepository;


@Service
public class OlxLoginServiceImpl implements OlxLoginService {
	
	@Autowired
	private UserRepository userRepository;

	
//static List<User> users=new ArrayList<User>();
//	
//	static {
//		users.add(new User(1L, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", 12345));
//		
//	}

	@Override
	public List<User> getAllUsers(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
			return userRepository.findAll();
			}
			
			return  null;
	}

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public boolean logoutUser(long id1, String username, String password){
		if(username.equals("anand")&&password.equals("anand123")) {
//			for(User user:users) {
//				if(user.getId()==id1) {
//					users.remove(user);
//					
//					
//					return true;
//				}
//				
//			}
			
			if(userRepository.existsById(id1)) {
			userRepository.deleteById(id1);
			return true;
			}
			else {
				return false;
			}
			
			
			
			
			
			
		}
		
		
		//	throw new InvalidIdException("Invalid id : "+id1);
			
			return false; 
		
		
		
	}

	@Override
	public String loginUser(User user) {
		return user.getUserName()+"\n"+user.getPassword();
	}

}
