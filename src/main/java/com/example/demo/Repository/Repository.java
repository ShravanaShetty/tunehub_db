package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface Repository  extends JpaRepository<Users,Integer>{
	public Users findByEmail(String email);

}
