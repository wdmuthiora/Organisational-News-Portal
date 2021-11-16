package models;

import java.util.Objects;

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

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setUser(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && getDepartmentId() == user.getDepartmentId() && getName().equals(user.getName()) && getPosition().equals(user.getPosition()) && getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, departmentId, role);
    }
}
