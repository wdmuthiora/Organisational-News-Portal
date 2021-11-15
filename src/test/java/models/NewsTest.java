package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("News Instantiates Correctly.")
    public void testInstanceOfNews_true(){
        News testNews = setUpNews();
        assertEquals(true, testNews instanceof News);
    }

 //helper
    private News setUpNews() {
        return new News (1, "Blog", 1, "news tonight","same ol'nonesense");
    }

}