package com.revature.lostchapterbackend.service;

import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.lostchapterbackend.dao.UserDao;
import com.revature.lostchapterbackend.exceptions.UsernameAlreadyExists;
import com.revature.lostchapterbackend.model.User;
import com.revature.lostchapterbackend.utility.HashUtil;

public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	private UserDao userDao;
	

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	@Transactional
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int register(User newUser) throws UsernameAlreadyExists {
		try 
		{
			newUser = userDao
		}catch(Exception e)
		{
			
		}	
		return 0;
	}

	@Override
	@Transactional
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}


	@Override
	@Transactional
	public String passwordHasher(String password) throws NoSuchAlgorithmException {
		String algorithm = "SHA-256";
		String hashedPassword = HashUtil.hashInputPassword(password.trim(), algorithm);
		return hashedPassword;
	}


	
	}

}
