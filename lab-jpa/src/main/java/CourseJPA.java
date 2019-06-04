import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "course")
@Table(name = "course")
public class CourseJPA {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "ects")
    private int ects;


    @ManyToMany(mappedBy = "courses")
    private Set<StudentJPA> students = new HashSet<>();

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private LecturerJPA lecturer;

    public CourseJPA() {
    }

    public CourseJPA(String name, int ects) {
        this.name = name;
        this.ects = ects;
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

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Set<StudentJPA> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentJPA> students) {
        this.students = students;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LecturerJPA getLecturer() {
        return lecturer;
    }

    public void setLecturer(LecturerJPA lecturer) {
        this.lecturer = lecturer;
    }



    @Override
    public String toString() {
        return "CourseRepository{" +
                "name='" + name + '\'' +
                ", ECTS=" + ects +
                ", students=" + students +
                '}';
    }
}
