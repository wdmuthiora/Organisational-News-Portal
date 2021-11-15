package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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



    //helper
    private User setUpNewUser() {
        return new User ("Betty", "lawyer", 1,"suits up");
    }

}