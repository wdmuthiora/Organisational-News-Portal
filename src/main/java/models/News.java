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

    //getters
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
}
