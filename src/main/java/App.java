import dao.Sql2oDepartmentsDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import exceptions.ApiException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.exception;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        Sql2oNewsDao sql2oNewsDao;
        Sql2oUserDao sql2oUsersDao;
        Sql2oDepartmentsDao sql2oDepartmentsDao;

        Connection conn;
        Gson gson = new Gson();


      String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal";

      Sql2o sql2o = new Sql2o(connectionString, "wangui", "33234159");


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
