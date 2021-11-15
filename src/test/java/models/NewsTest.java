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

    @Test
    @DisplayName("News Instantiates Correctly the Id 1.")
    public void getId_newsInstantiatesWithId_1() {
        News testNews = setUpNews();
        assertEquals(1, testNews.getId());
    }

    @Test
    @DisplayName("News Instantiates Correctly the newsType Blog")
    public void getNewsType_newsInstantiatesWithNewsType_Blog() {
        News testNews = setUpNews();
        assertEquals("Blog", testNews.getBlog());
    }

    @Test
    @DisplayName("News Instantiates Correctly the newsType Blog")
    public void getNewsType_newsInstantiatesWithDepartmentId_1() {
        News testNews = setUpNews();
        assertEquals(1, testNews.getDepartmentId());
    }

    @Test
    @DisplayName("News Instantiates Correctly the title news tonight")
    public void getTitle_newsInstantiatesWithTitle_news_tonight1() {
        News testNews = setUpNews();
        assertEquals("news tonight", testNews.getTitle());
    }

    @Test
    @DisplayName("News Instantiates Correctly the description nonsense")
    public void getDescription_newsInstantiatesWithDescription_some_nonsense() {
        News testNews = setUpNews();
        assertEquals("nonsense", testNews.getDescription());
    }

 //helper
    private News setUpNews() {
        return new News (1, "Blog", 1, "news tonight","nonsense");
    }

}