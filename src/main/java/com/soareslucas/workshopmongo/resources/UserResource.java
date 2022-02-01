package com.soareslucas.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		
	@GetMapping(value = "/{id}")	
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
		
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable String id){
		 service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto,@PathVariable String id){
		User obj = service.fromDTO(objDto);
		obj.setId(id); //para garantir que o id ficara o mesmo na hora de dar update.
		return ResponseEntity.noContent().build();
	}
}
