import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="student")
public class StudentJPA implements Serializable {
    @Id
    @Column(name = "studentId")
    private int indexNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Embedded
    private AddressJPA address;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AvatarJPA avatar;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "courses",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<CourseJPA> courses = new HashSet<>();


    public StudentJPA() {
        super();
    }

    public StudentJPA(String firstName, String lastName, AddressJPA address) {
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

    public AddressJPA getAddress() {
        return address;
    }

    public void setAddress(AddressJPA address) {
        this.address = address;
    }

    public Set<CourseJPA> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseJPA> courses) {
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
