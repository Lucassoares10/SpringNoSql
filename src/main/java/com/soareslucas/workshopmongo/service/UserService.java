package com.soareslucas.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soareslucas.workshopmongo.entities.User;
import com.soareslucas.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll(); 
	}
	
}
