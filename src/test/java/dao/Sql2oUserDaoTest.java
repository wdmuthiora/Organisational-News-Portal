package dao;

import models.Departments;
import models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oUserDaoTest {
    private static Sql2oDepartmentsDao sql2oDepartmentsDao;
    private static Sql2oUserDao sql2oUserDao;
    private static Connection conn;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        sql2oDepartmentsDao.clearAll();
        sql2oUserDao.clearAll();
        System.out.println("Database cleared");
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("Connection to database closed");
    }




    //helper
    private User setUpNewUser() {
        return new User ("Betty", "lawyer", 1,"suits up");
    }

    private Departments setUpDepartments() {
        return new Departments ("Legal", "lawyers");
    }
}
