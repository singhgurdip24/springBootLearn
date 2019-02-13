package com.learnSpringBoot.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoService {
	
	private static List<user> users=new ArrayList<>();
	private static int userCount=3;
	static {
		users.add(new user(1,"Adam",new Date()));
		users.add(new user(2,"Eve",new Date()));
		users.add(new user(3,"Monday",new Date()));
	}
	
	public List<user> findAll(){
		return users;
	}
	
	public user save(user user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public user findOne(int id) {
		for(user user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
		
	}
	public user deleteById(int id) {
		Iterator<user> it=users.iterator();
		while(it.hasNext())
		{
			user user=it.next();
			if(user.getId()==id) {
				 it.remove();
				 return user;
			}
		}
		return null;
		
	}
}
