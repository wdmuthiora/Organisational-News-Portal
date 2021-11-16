package dao;

import dao.interfaces.UserDao;
import models.Departments;
import models.User;

import java.util.List;

public class Sql2oUserDao implements UserDao {


    @Override
    public void add(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<Departments> getAllUserDepartments(int user_id) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void clearAll() {

    }
}
