
package com.learnSpringBoot.rest.webservices.restfulwebservices.user;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="details")
public class user {

	private Integer id;
	
	@Size (min=2, message="name should have at least two characters")
	@ApiModelProperty(notes="name should have at least two characters")
	private String name;
	@Past
	@ApiModelProperty(notes="date of birth should be in past")
	private Date dob;
	
	protected user() {}
	
	public user(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

	
	
	
	
}
