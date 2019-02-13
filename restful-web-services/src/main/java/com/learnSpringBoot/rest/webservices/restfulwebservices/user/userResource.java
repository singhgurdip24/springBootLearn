package com.learnSpringBoot.rest.webservices.restfulwebservices.user;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class userResource {
	
	@Autowired
	private userDaoService service;
	
	@GetMapping("/users")
	public List<user> retrieveAllUsers(){
		
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<user> retrieveOne(@PathVariable int id){
		user user= service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		
		//return all users link along with one info
		
		Resource<user> allUsersLink=new Resource<user>(user);
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		allUsersLink.add(link.withRel("all-users-link"));
		
		return allUsersLink;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteOne(@PathVariable int id){
		user user= service.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody user user) {
		 user savedUser=service.save(user);
		 
		 URI location=ServletUriComponentsBuilder
				 				.fromCurrentRequest()
				 				.path("/{id}")
				 				.buildAndExpand(savedUser.getId())
				 				.toUri();
		 
		return ResponseEntity.created(location).build();
	}
}
