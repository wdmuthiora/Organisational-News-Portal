package dao.interfaces;

import models.Departments;
import models.User;

import java.util.List;

public interface UserDao {

    //create
    void  add(User user);

    //read
    List<User> getAll();
    List<Departments> getAllUserDepartments(int user_id);
    User findById(int id);

    //update

    //delete
    void clearAll();
}