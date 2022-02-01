package com.soareslucas.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soareslucas.workshopmongo.dto.UserDTO;
import com.soareslucas.workshopmongo.entities.User;
import com.soareslucas.workshopmongo.repository.UserRepository;
import com.soareslucas.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll(); 
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}



}
