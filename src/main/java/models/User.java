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

    public String getName() {
        return name;
    }


    //getters
    //setters

}
