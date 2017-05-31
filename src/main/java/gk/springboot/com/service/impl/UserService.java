package gk.springboot.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gk.springboot.com.mapper.UserMapper;
import gk.springboot.com.model.User;
import gk.springboot.com.model.UserExample;
import gk.springboot.com.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUsers() {
		return userMapper.selectByExample(new UserExample());
	}

}
