package pl.edu.agh.soa.api;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentContainer {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAll() {
        return new ArrayList<>(students);
    }
}
