package dao;

import dao.interfaces.UserDao;
import models.Departments;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO users (name, position, department_id, role) VALUES (:name, :position, :department_id, :role) ";
            int id=(int) conn.createQuery(sql,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
            System.out.println("Failed to add user");
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection con = sql2o.open()){
            String sql=("SELECT * FROM users");
            return con.createQuery(sql)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<Departments> getAllUserDepartments(int userId) {
        List<Departments> departments = new ArrayList<>();
        try (Connection con = sql2o.open()) {
            String sql = "SELECT department_id FROM users_departments WHERE user_id = :userId";
            List<Integer> departmentIds = con.createQuery(sql)
                    .addParameter("user_id", userId)
                    .executeAndFetch(Integer.class);
            for (Integer id : departmentIds) {
                String userResults = "SELECT * FROM departments WHERE id = :id";
                departments.add(con.createQuery(userResults)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Departments.class));
            }
            return departments;
        }
    }

    @Override
    public User findById(int id) {
        try (Connection con = sql2o.open()){
            String sql=("SELECT * FROM users WHERE id = :id");
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void clearAll() {
        try (Connection con=sql2o.open()){
            String sql = "DELETE FROM users ";
            con.createQuery(sql).executeUpdate();
            String sqlUsersDepartments = "DELETE FROM users_departments";
            con.createQuery(sqlUsersDepartments).executeUpdate();


        }catch (Sql2oException ex){
            System.out.println(ex);
            System.out.println("Could not delete users");
        }
    }

}
