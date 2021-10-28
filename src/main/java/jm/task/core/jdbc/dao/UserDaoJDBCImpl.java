package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {

        String sqlCommand = "CREATE TABLE userdata (ID INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(20), LastName VARCHAR(20), Age INT(3)) ";
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            System.out.println("Table is already exist...");
        }
    }

    public void dropUsersTable() {

        String sqlCommand = "DROP TABLE userdata";
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            System.out.println("Table is not exist...");
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        String sqlCommand = "INSERT  into  userdata(Name, LastName, Age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.execute();
        } catch (SQLException throwables) {
            System.out.println("User cannot be added, check connection");
        }
    }

    public void removeUserById(long id) {

        String sqlCommand = "DELETE from userdata where ID  = " + id;
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            System.out.println("Table is not exist...");
        }
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        String sqlCommand = "SELECT * FROM userdata";
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                users.add(user);
            }
        } catch (SQLException throwables) {
            System.out.println("Cannot show table");
        }
        return users;
    }

    public void cleanUsersTable() {

        String sqlCommand = "DELETE from userdata";
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            System.out.println("Table is not exist...");
        }
    }
}



