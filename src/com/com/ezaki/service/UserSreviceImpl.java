package com.ezaki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ezaki.model.User;
import com.ezaki.repository.UserRepository;

@Service
@Qualifier("com.ezaki")
public class UserSreviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {    	
		return userRepository.findById(id);

	}
	@Override
	public User findByEmail(String email) {    	
		return userRepository.findByEmail(email);

	}
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User update(User newUser, Long id)  {
		Optional<User> oldUser = findById(id);
		User user = oldUser.get();
		if(oldUser.isPresent()){			
			user.setFirstName(newUser.getFirstName());
			save(user);
			
		}
		return user;
	}
}
