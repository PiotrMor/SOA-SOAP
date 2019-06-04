package model;

import java.util.ArrayList;
import java.util.List;

public class Lecturer {
    private String name;
    //private List<Course> courses = new ArrayList<>();

    public Lecturer() {
    }

    public Lecturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }*/

    @Override
    public String toString() {
        return "Lecturer{" +
                "name='" + name + '\'' +
                '}';
    }
}
