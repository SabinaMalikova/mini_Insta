package service;

import models.User;

import java.util.List;

public interface UserService {
    String registration (User user);
    String login(String email, String password);
    User getUserByEmail(String email);
    List <User> getAllUsers();

}
