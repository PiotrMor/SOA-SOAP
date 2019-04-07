package pl.edu.agh.soa.api;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@XmlRootElement(name = "student")

@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    private int indexNumber;
    private String firstName;
    private String lastName;
    private int age;
    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    private List<String> courses = new ArrayList<>();

    public Student() {
    }

    public Student(int indexNumber, String firstName, String lastName, int age, List<String> courses) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }


}
