package models;

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

    //setters
}
