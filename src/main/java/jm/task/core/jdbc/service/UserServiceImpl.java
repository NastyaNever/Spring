package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao db = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() {
        db.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        db.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        db.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        db.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return db.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        db.cleanUsersTable();
    }
}
