package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Departments Instantiates Correctly.")
    public void testInstanceOfDepartments_true(){
        Departments testDepartments = setUpDepartments();
        assertEquals(true, testDepartments instanceof Departments);
    }

    @Test
    @DisplayName("Departments Instantiates Correctly the name Legal.")
    public void getName_RetrievesName_Legal() {
        Departments testDepartments = setUpDepartments();
        assertEquals("Legal", testDepartments.getName());
    }

    @Test
    @DisplayName("Departments Instantiates Correctly the description lawyers.")
    public void getDescription_RetrievesDescription_lawyers() {
        Departments testDepartments = setUpDepartments();
        assertEquals("lawyers", testDepartments.getDescription());
    }

    @Test
    @DisplayName("Departments Instantiates Correctly the id 1.")
    public void getId_RetrievesId_1() {
        Departments testDepartments = setUpDepartments();
        assertEquals("lawyers", testDepartments.getId());
    }

    //helper
    private Departments setUpDepartments() {
        return new Departments ("Legal", "lawyers");
    }
}