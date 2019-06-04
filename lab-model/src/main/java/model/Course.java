package model;

import java.io.Serializable;

public class Course {
    private String name;
    private int ects;
    private Lecturer lecturer;

    public Course() {
    }

    public Course(String name, int ects, Lecturer lecturer) {
        this.name = name;
        this.ects = ects;
        this.lecturer = lecturer;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", ects=" + ects +
                ", lecturer=" + lecturer +
                '}';
    }
}
