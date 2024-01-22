package com.example.demo.Service;

import com.example.demo.entity.Users;

public interface UsersService {
 public String addUser(Users us);
 public boolean emailExits(String email);
boolean validationUser(String email, String password);
String getrole(String email);
public Users getUser(String email);
public void updateUser(Users us);

}
