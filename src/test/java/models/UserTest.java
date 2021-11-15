package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("User Instantiates Correctly.")
    public void testInstanceOfAnimal_true(){
        User testUser = setUpNewUser();
        assertEquals(true, testUser instanceof User);
    }

    @Test
    @DisplayName("User Instantiates Correctly the name Betty.")
    public void getName_userInstantiatesWithName_Betty() {
        User testUser = setUpNewUser();
        assertEquals("Betty", testUser.getName());
    }

    @Test
    @DisplayName("User Instantiates Correctly the position lawyer.")
    public void getPosition_userInstantiatesWithPosition_Lawyer() {
        User testUser = setUpNewUser();
        assertEquals("lawyer", testUser.getPosition());
    }

    @Test
    @DisplayName("User Instantiates Correctly the departmentId 1.")
    public void getDepartmentId_userInstantiatesWithDepartmentId_1() {
        User testUser = setUpNewUser();
        assertEquals(1, testUser.getDepartmentId());
    }

    @Test
    @DisplayName("User Instantiates Correctly the role suits up.")
    public void getRole_userInstantiatesWithRole_suits_up() {
        User testUser = setUpNewUser();
        assertEquals("suits up", testUser.getRole());
    }

    @Test
    @DisplayName("User Instantiates Correctly and sets name to Cow.")
    public void setName_userInstantiatesAndSetsName_Cow() {
        User testUser = setUpNewUser();
        testUser.setName("cow");
        assertEquals("cow", testUser.getName());
    }

    @Test
    @DisplayName("User Instantiates Correctly and sets position to spy.")
    public void setPosition_userInstantiatesAndSetsPosition_spy() {
        User testUser = setUpNewUser();
        testUser.setPosition("spy");
        assertEquals("spy", testUser.getPosition());
    }

    @Test
    @DisplayName("User Instantiates Correctly and sets departmentId to 2.")
    public void setDepartmentId_userInstantiatesAndSetsDepartmentId_2() {
        User testUser = setUpNewUser();
        testUser.setDepartmentId(2);
        assertEquals(2, testUser.getDepartmentId());
    }
    @Test
    @DisplayName("User Instantiates Correctly and sets role to tear-down.")
    public void setRole_userInstantiatesAndSetsRole_tearDown() {
        User testUser = setUpNewUser();
        testUser.setUser("tear-down");
        assertEquals("tear-down", testUser.getRole());
    }

    //helper
    private User setUpNewUser() {
        return new User ("Betty", "lawyer", 1,"suits up");
    }

}