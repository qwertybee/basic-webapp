package io.muic.ooc.webapp.database;

import io.muic.ooc.webapp.security.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Database {

    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssc_2021",
                    "ssc", "A123456b");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ssc_2021.user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public boolean authenticatedUser(String username, String password) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT password FROM ssc_2021.user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String hashedPass = rs.getString("password");
                check = BCrypt.checkpw(password, hashedPass);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean isUser(String username) {
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ssc_2021.user WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
    
    public void addUser(String username, String password, String name) {
        String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ssc_2021.user VALUES (DEFAULT, ?, ?, ?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPass);
            preparedStatement.setString(3, name);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUser(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ssc_2021.user WHERE username=?");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ssc_2021.user");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                User user = new User(username, password, name, id);
                allUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsers;
    }

    public void editUser(int currentid, String changeUsername, String changePassword, String changeName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE ssc_2021.user SET username=?, password=?, name=? WHERE id=?");
            preparedStatement.setString(1, changeUsername);
            preparedStatement.setString(2, BCrypt.hashpw(changePassword, BCrypt.gensalt()));
            preparedStatement.setString(3, changeName);
            preparedStatement.setInt(4, currentid);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    
}
