package com.ezaki.service;

import java.util.List;
import java.util.Optional;

import com.ezaki.model.User;

public interface UserService {
	
	public List<User> findAll();

    public Optional<User> findById(Long id);
    
    public User findByEmail(String email);
   
    public User save(User user) ;

    public User update(User newUser, Long id);
    
    public void deleteById(Long id);

}
