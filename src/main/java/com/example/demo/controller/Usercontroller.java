package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.UsersService;
import com.example.demo.entity.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class Usercontroller {
	
	@Autowired
	UsersService repo;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users us) {
		
		boolean user_status=repo.emailExits(us.getEmail());
		if(user_status==false) {
			repo.addUser(us);
		}
		else {
			System.out.println("User already present");
			
		}
		return "home";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam ("email") String email,@RequestParam("password") String password,HttpSession session) {
		
		if(repo.validationUser(email,password) ==true){
			String role=repo.getrole(email);
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminhome";
				
			}
			else {
				return "customerhome";
			}
			
		}
		else {
			return "login";
		}
	}
	//@GetMapping("/pay")
	//public String pay(@RequestParam String email) {
		//boolean paymentStatus=false;//payment api
		
		//if(paymentStatus==true) {
			//Users us= repo.getUser(email);
			//us.setPremium(true);
			//repo.updateUser(us);
			
		//}
//		return "login";
		
	//}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
		
	}
	
}
