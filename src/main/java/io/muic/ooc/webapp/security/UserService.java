package io.muic.ooc.webapp.security;

import io.muic.ooc.webapp.database.Database;

import java.util.List;

public class UserService {

    private Database database;

    public UserService() {
        this.database = new Database();
    }

    public boolean authenticatedUser(String username, String password) {
        return database.authenticatedUser(username, password);
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

    public List<User> getAllUsers() {
        return database.getAllUsers();
    }

    public void editUser(int id, String username, String password, String name) {
        database.editUser(id, username, password, name);
    }

}
