package com.learnSpringBoot.rest.webservices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping( path="/hello-world")
	public String helloWorld() {
		return "Hello Spring";
	}
	
	@GetMapping( path="/hello-world-bean")
	public beanClass helloWorldBean() {
		return new beanClass("Hello Spring");
	}

	@GetMapping( path="/hello-world/path-variable/{name}")
	public beanClass helloWorld(@PathVariable String name) {
		return new beanClass(String.format("Hello Spring, %s",name));
	}	
	
	@GetMapping( path="/helloWorldInternationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
		
}
