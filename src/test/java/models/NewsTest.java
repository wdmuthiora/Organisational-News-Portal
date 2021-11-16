package models;

import org.h2.util.New;
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
    @DisplayName("News Retrieves UserId 1.")
    public void getUserId_RetrievesUserId_1() {
        News testNews = setUpNews();
        assertEquals(1, testNews.getUserId());
    }

    @Test
    @DisplayName("News Instantiates Correctly the Id 1.")
    public void getId_RetrievesId_1() {
        News testNews = setUpNews();
        assertEquals(0, testNews.getId());
    }

    @Test
    @DisplayName("News sets the Id to 2.")
    public void setId_setsIdTo_2() {
        News testNews = setUpNews();
        testNews.setId(2);
        assertEquals(2, testNews.getId());
    }

    @Test
    @DisplayName("News Instantiates Correctly the newsType general")
    public void getNewsType_RetrievesNewsType_general() {
        News testNews = setUpNews();
        assertEquals("general", testNews.getNewsType());
    }

    @Test
    @DisplayName("News sets newsType to Alert")
    public void SetNewsType_SetsNewsType_Alert() {
        News testNews = setUpNews();
        testNews.setNewsType("Alert");
        assertEquals("Alert", testNews.getNewsType());
    }

    @Test
    @DisplayName("News Instantiates Correctly the newsType Blog")
    public void getDepartment_RetrievesDepartmentId_1() {
        News testNews = setUpNews();
        assertEquals(0, testNews.getDepartmentId());
    }

    @Test
    @DisplayName("News sets departmentId to Alert")
    public void SetDepartmentId_SetsDepartmentId_2() {
        News testNews = setUpNews();
        testNews.setDepartmentId(2);
        assertEquals(2, testNews.getDepartmentId());
    }

    @Test
    @DisplayName("News Instantiates Correctly the title news tonight")
    public void getTitle_RetrievesTitle_news_tonight1() {
        News testNews = setUpNews();
        assertEquals("title", testNews.getTitle());
    }

    @Test
    @DisplayName("News sets departmentId to Alert")
    public void SetTitle_SetsTitle_nope() {
        News testNews = setUpNews();
        testNews.setTitle("nope");
        assertEquals("nope", testNews.getTitle());
    }

    @Test
    @DisplayName("News Instantiates Correctly the description description")
    public void getDescription_newsInstantiatesWithDescription_description() {
        News testNews = setUpNews();
        assertEquals("description", testNews.getDescription());
    }

    @Test
    @DisplayName("News sets description to Alert")
    public void SetDescription_SetsDescription_alert() {
        News testNews = setUpNews();
        testNews.setDescription("Alert");
        assertEquals("Alert", testNews.getDescription());
    }

 //helper

    private News setUpNews2(){
        return new  News("title", "description", 1, 1);
    }
    private News setUpNews(){
        return new News("title", "description", 1);
    }

}