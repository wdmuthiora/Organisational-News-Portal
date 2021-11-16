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
    public void testInstanceOfAnimal_true(){
        Departments testDepartments = setUpDepartments();
        assertEquals(true, testDepartments instanceof Departments);
    }

    //helper
    private Departments setUpDepartments() {
        return new Departments ("Betty", "lawyer");
    }
}