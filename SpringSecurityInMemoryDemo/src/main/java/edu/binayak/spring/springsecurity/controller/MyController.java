/**
 * 
 */
package edu.binayak.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 *
 */
@RestController
public class MyController {
	
	@GetMapping("/home")
	public String getHome() {
		return "Home";
	}
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "Welcome";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Admin";
	}
	
	@GetMapping("/emp")
	public String getEmp() {
		return "Emp";
	}
	
	@GetMapping("/student")
	public String getStudent() {
		return "Student";
	}
	
	@GetMapping("/denied")
	public String getDenied() {
		
		return "Forbidden";
	}
	
}
