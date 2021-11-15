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
    @DisplayName("Users Instantiates Correctly.")
    public void testInstanceOfAnimal_true(){
        User testUser = setUpNewUser();
        assertEquals(true, testUser instanceof User);
    }




    //helper
    private User setUpNewUser() {
        return new User ();
    }

}