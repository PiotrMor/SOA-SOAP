import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="student")
public class StudentRepository implements Serializable {
    @Id
    @Column(name = "studentId")
    private int indexNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Embedded
    private AddressRepository address;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AvatarRepository avatar;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "courses",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<CourseRepository> courses = new HashSet<>();


    public StudentRepository() {
        super();
    }

    public StudentRepository(String firstName, String lastName, AddressRepository address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public AddressRepository getAddress() {
        return address;
    }

    public void setAddress(AddressRepository address) {
        this.address = address;
    }

    public Set<CourseRepository> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseRepository> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "id=" + indexNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
