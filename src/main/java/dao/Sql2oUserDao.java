package dao;

import dao.interfaces.UserDao;
import models.Departments;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO users (name,position, department_id, role) VALUES (:name, :position, :departmentId, :role) ";
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
