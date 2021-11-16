package models;

import java.util.Objects;

public class Departments {

    private String name;
    private String description;
    private int id;
        private int size;

    //constructor
    public Departments(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departments)) return false;
        Departments that = (Departments) o;
        return getId() == that.getId() && getSize() == that.getSize() && getName().equals(that.getName()) && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, id, size);
    }
}
