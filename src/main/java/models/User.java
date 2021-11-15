package models;

public class User {

    //properties
    private int id;
    private String name;
    private String position;
    private int departmentId;
    private String role;

    //constructor

    public User(String name, String position, int departmentId, String role) {
        this.name = name;
        this.position = position;
        this.departmentId = departmentId;
        this.role = role;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }


    //setters

}
