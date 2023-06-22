package fr.liu.myApi.service;

import org.springframework.stereotype.Service;

import fr.liu.myApi.model.User;
import java.util.ArrayList;

@Service
public class UserService {
    
    private ArrayList<User> users;

    public UserService() {
        this.users = new ArrayList<User>();

        User u1 = new User(0,"Pierre",30);
        User u2 = new User(1, "Lina", 25);
        User u3 = new User(2, "Laurent", 40);

        this.users.add(u1);
        this.users.add(u2);
        this.users.add(u3);
    }

    public User getUser(int id) {
        for (User user : this.users) {
            if (user.getId() == id) {
                return user;
            } 
        }
            return null;      
    }
}
