package service.serviceImpl;

import models.DataBase;
import models.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public String registration(User user) {
        DataBase.users.add(user);
        return user.getFullName()+" successfully added.";
    }


    @Override
    public String login(String email, String password) {
        for (User user : DataBase.users){
            try {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return "successfully";
                }
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
        return "error, try again";
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : DataBase.users){
            try {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }catch (NullPointerException e ){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return DataBase.users;
    }
}
