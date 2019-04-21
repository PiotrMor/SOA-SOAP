package api;

import model.Student;

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

    public List<Student> getAll() {
        return students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean deleteStudent(int indexNumber) {
        return students.removeIf(student -> student.getIndexNumber() == indexNumber);
    }
}
