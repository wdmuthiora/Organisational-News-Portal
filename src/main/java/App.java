import com.google.gson.Gson;
import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import exceptions.ApiException;
import models.Departments;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        Sql2oNewsDao sql2oNewsDao;
        Sql2oUserDao sql2oUserDao;
        Sql2oDepartmentsDao sql2oDepartmentsDao;
        Connection conn;
        Gson gson = new Gson();

        //setup Local connection
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234567890");

        sql2oDepartmentsDao = new Sql2oDepartmentsDao(sql2o);
        sql2oNewsDao = new Sql2oNewsDao(sql2o);
        sql2oUserDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();

        //get routes
        get("/users", "application/json", (request, response) -> {
            if(sql2oDepartmentsDao.getAll().size() > 0){
                return gson.toJson(sql2oUserDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no users are currently listed in the database.\"}";
            }
        });

        get("/user/:id", "application/json", (request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            if(sql2oUserDao.findById(id) == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists",
                        request.params("id")));
            }
            else {
                return gson.toJson(sql2oUserDao.findById(id));
            }
        });

        get("/user/:id/departments","application/json",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            if(sql2oUserDao.getAllUserDepartments(id).size()>0){
                return gson.toJson(sql2oUserDao.getAllUserDepartments(id));
            }
            else {
                return "{\"message\":\"I'm sorry, but user is in no department.\"}";
            }
        });

        get("/departments","application/json",(request, response) -> {
            if(sql2oDepartmentsDao.getAll().size()>0){
                return gson.toJson(sql2oDepartmentsDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
            }
        });

        get("/department/:id","application/json",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            if(sql2oDepartmentsDao.findById(id) == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists",
                        request.params("id")));
            }
            else {
                return gson.toJson(sql2oDepartmentsDao.findById(id));
            }
        });

        get("/department/:id/users","application/json",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            if(sql2oDepartmentsDao.getAllUsersInDepartment(id).size()>0){
                return gson.toJson(sql2oDepartmentsDao.getAllUsersInDepartment(id));
            }
            else {
                return "{\"message\":\"I'm sorry, but department has no users.\"}";
            }
        });

        get("/news/general","application/json",(request, response) -> {
            if(sql2oNewsDao.getAll().size()>0){
                return gson.toJson(sql2oNewsDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no news are currently listed in the database.\"}";
            }
        });

        get("/news/department/:id","application/json",(request, response) -> {

            int id = Integer.parseInt(request.params("id"));
            Departments departments = sql2oDepartmentsDao.findById(id);
            if(departments == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists",
                        request.params("id")));
            }
            if(sql2oDepartmentsDao.getDepartmentNews(id).size()>0){
                return gson.toJson(sql2oDepartmentsDao.getDepartmentNews(id));
            }
            else {
                return "{\"message\":\"I'm sorry, but no news in this department.\"}";
            }
        });

        //post routes
        post("/user/new","application/json",(request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            sql2oUserDao.add(user);
            response.status(201);
            return gson.toJson(user);
        });

        post("/departments/new","application/json",(request, response) -> {
            Departments departments = gson.fromJson(request.body(), Departments.class);
            sql2oDepartmentsDao.add(departments);
            response.status(201);
            return gson.toJson(departments);
        });

        post("/news/new/general","application/json",(request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.addNews(news);
            response.status(201);
            return gson.toJson(news);
        });

        post("/news/new/department","application/json",(request, response) -> {
            News department_news = gson.fromJson(request.body(), News.class);
            Departments departments = sql2oDepartmentsDao.findById(department_news.getDepartmentId());
            User users = sql2oUserDao.findById(department_news.getUserId());
            if(departments == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists",
                        request.params("id")));
            }
            if(users == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists",
                        request.params("id")));
            }
            sql2oNewsDao.addNews(department_news);
            response.status(201);
            return gson.toJson(department_news);
        });

        post("/add/user/:user_id/department/:department_id","application/json",(request, response) -> {

            int user_id = Integer.parseInt(request.params("user_id"));
            int department_id = Integer.parseInt(request.params("department_id"));
            Departments departments = sql2oDepartmentsDao.findById(department_id);
            User user = sql2oUserDao.findById(user_id);
            if(departments == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists",
                        request.params("department_id")));
            }
            if(user == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists",
                        request.params("user_id")));
            }
            sql2oDepartmentsDao.addUserToDepartment(user, departments);
            List<User> departmentUsers = sql2oDepartmentsDao.getAllUsersInDepartment(departments.getId());
            response.status(201);
            return gson.toJson(departmentUsers);
        });

        //FILTERS
        exception(ApiException.class, (exception, request, response) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            response.type("application/json");
            response.status(err.getStatusCode());
            response.body(gson.toJson(jsonMap));
        });

        after((request, response) -> {
            response.type("application/json");
        });
    }
}
