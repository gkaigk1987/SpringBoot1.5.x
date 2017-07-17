package gk.springboot.com.service;

import java.util.List;

import gk.springboot.com.model.User;
import gk.springboot.com.model.UserExample;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public User getUserById(String id);
	
	public List<User> getUsersByExample(UserExample example);
}
