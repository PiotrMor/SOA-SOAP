package pl.edu.agh.soa.api;



import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService
@DeclareRoles({"developer"})
@WebContext(authMethod="BASIC", transportGuarantee="NONE", secureWSDLAccess=false)
@SecurityDomain("student-domain")
@PermitAll
public class Main {
    private List<Student> students = new ArrayList<>();
    private static final String avatarPath = "././resources/avatar.png";

    @WebMethod
    @RolesAllowed("developer")
    public Student addStudent(@WebParam(name = "indexNumber") final int indexNumber, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName,
                           @WebParam(name = "age") int age, @WebParam(name = "courses") List<String> courses) {

        Student newStudent = null;
        if (students.stream().noneMatch(s -> s.getIndexNumber() == indexNumber)) {
            newStudent = new Student(indexNumber, firstName, lastName, age, courses);
            students.add(newStudent);
        }
        return newStudent;

    }

    @WebMethod
    public Student updateStudent(@WebParam(name = "indexNumber") final int indexNumber, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName,
                              @WebParam(name = "age") int age, @WebParam(name = "courses") List<String> courses) {
        Student student = students.stream().filter(s -> s.getIndexNumber() == indexNumber).findFirst().orElse(null);

        if (student == null) {
            return null;
        }

        student.setAge(age);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setCourses(courses);
        return student;
    }

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @WebMethod
    public List<Student> getStudentList() {
        return students;
    }

    @XmlElement(name = "student")
    @WebMethod
    public Student getStudentById(@WebParam(name = "indexNumber") int indexNumber) {
        return students.stream().filter(s -> s.getIndexNumber() == indexNumber).findFirst().orElse(null);
    }

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @WebMethod
    public List<Student> getStudentsByAge(@WebParam(name = "age") int age) {
        return students.stream().filter(s -> s.getAge() == age).collect(Collectors.toList());
    }

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @WebMethod
    public List<Student> getStudentsByFirstName(@WebParam(name = "firstName") String firstName) {
        return students.stream().filter(s -> s.getFirstName().equals(firstName)).collect(Collectors.toList());
    }

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @WebMethod
    public List<Student> getStudentsByLastName(@WebParam(name = "lastName") String lastName) {
        return students.stream().filter(s -> s.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @WebMethod
    public List<Student> getStudentsByCourse(@WebParam(name = "course") String course) {
        return students.stream().filter(s -> s.getCourses().contains(course)).collect(Collectors.toList());
    }

    @WebMethod
    public String getAvatar() {
        return Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png");
    }
}
