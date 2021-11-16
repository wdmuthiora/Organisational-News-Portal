package dao;

import models.Departments;
import models.News;
import models.User;

import java.util.List;

public interface DepartmentsDao {

    //Create
    void add(Departments department);
    void addUserToDepartment(User user, Departments department);

    //Read
    List<Departments> getAll();
    Departments findById(int id);
    List<User> getAllUsersInDepartment(int department_id);
    List<News> getDepartmentNews(int id);

    //Update

    //Delete
    void clearAll();

}