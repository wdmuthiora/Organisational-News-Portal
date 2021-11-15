package models;

public class News {
    private int id;
    private String newsType;
    private int departmentId;
    private int userId;
    private String title;
    private String description;
    private final String TYPE_OF_NEWS="general";

    public News(int id, String newsType, int departmentId, String title, String description) {
        this.id=  id;
        this.newsType = newsType;
        this.departmentId = departmentId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getBlog() {
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

    //getters

    //setters
}
