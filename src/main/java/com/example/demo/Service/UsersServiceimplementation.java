package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.Repository;
import com.example.demo.entity.Users;

@Service
public class UsersServiceimplementation implements UsersService{
	
	@Autowired
	Repository repo;
	

	@Override
	public String addUser(Users us) {
		
		repo.save(us);
		return "User is added Sucessfully";
	}

	@Override
	public boolean emailExits(String email) {
		if(repo.findByEmail(email)==null) {
		
		return false;
	}
	else {
		return true;
	}
	}
	@Override
	public boolean validationUser(String email,String password) {
			Users us=repo.findByEmail(email);
		String db_pass=us.getPassword();
		if(password.equals(db_pass))
		{
		
		return true;
	}
	else {
		return true;
	}
		}
	@Override
	public String getrole(String email) {
		 
			 Users us=repo.findByEmail(email);
			 return us.getRole();
			 
		 }

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Users us) {
		// TODO Auto-generated method stub
		repo.save(us);
	}

	
	
	
	
}
