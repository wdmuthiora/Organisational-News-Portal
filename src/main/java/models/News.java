package models;

import java.util.Objects;

public class News {

    private int id;
    private String newsType;
    private int departmentId;
    private int userId;
    private String title;
    private String description;
    private final String TYPE_OF_NEWS = "general";

   //constructors
    public News(String title, String description, int user_id) {
        this.title = title;
        this.description = description;
        this.userId = user_id;
        this.newsType = TYPE_OF_NEWS;
        this.departmentId = 0;
    }

    public News(String title, String description,int department_id, int user_id){
        this.title = title;
        this.description = description;
        this.userId=user_id;
        this.departmentId = department_id;
        this.newsType = "department";
    }

    //getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getNewsType() {
        return newsType;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getId() == news.getId() && getDepartmentId() == news.getDepartmentId() && userId == news.userId && newsType.equals(news.newsType) && getTitle().equals(news.getTitle()) && getDescription().equals(news.getDescription()) && TYPE_OF_NEWS.equals(news.TYPE_OF_NEWS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newsType, departmentId, userId, title, description, TYPE_OF_NEWS);
    }
}
