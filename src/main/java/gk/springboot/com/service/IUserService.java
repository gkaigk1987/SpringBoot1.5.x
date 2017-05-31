package gk.springboot.com.service;

import java.util.List;

import gk.springboot.com.model.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(String id);
	

}
