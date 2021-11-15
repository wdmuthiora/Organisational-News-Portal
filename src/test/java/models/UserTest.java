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


    //helper
    private User setUpNewUser() {
        return new User ("Betty", "lawyer", 1,"suits up");
    }

}