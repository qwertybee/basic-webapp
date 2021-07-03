package io.muic.ooc.webapp.security;

import io.muic.ooc.webapp.database.Database;

import java.util.HashMap;

public class UserService {

    private Database database;
//    private HashMap<String, User> allUsers;

    public UserService() {
        this.database = new Database();
//        this.allUsers = database.getAllUsers();
    }

    public boolean authenticateUser(String username, String password) {
        return database.authenticateUser(username, password);
    }

    public boolean checkIfUserExists(String username) {
        return database.isUser(username);
    }

    public void addUser(String username, String password, String name) {
        database.addUser(username, password, name);
    }

    public void removeUser(String username) {
        database.removeUser(username);
    }

    public HashMap<String, User> getAllUsers() {
        return database.getAllUsers();
    }

    public void editUser(int id, String username, String password, String name) {
        database.editUser(id, username, password, name);
    }

//    public User findByUsername(String username) {
//        return database.;
//    }


}
