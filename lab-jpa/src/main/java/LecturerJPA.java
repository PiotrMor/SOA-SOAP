import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecturer")
public class LecturerJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "lecturer")
    private List<CourseJPA> courses = new ArrayList<>();


    public LecturerJPA() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseJPA> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseJPA> courses) {
        this.courses = courses;
    }
}
