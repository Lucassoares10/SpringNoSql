package com.soareslucas.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soareslucas.workshopmongo.dto.UserDTO;
import com.soareslucas.workshopmongo.entities.User;
import com.soareslucas.workshopmongo.service.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
		@Autowired
		private UserService service;
		
		@GetMapping
		public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //transformando a lista de user em ListDto e convertendo ela para list usando lambda
		return ResponseEntity.ok().body(listDto);
		}		
}
