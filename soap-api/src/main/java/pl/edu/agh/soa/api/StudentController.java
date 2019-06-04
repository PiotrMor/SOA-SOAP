package pl.edu.agh.soa.api;



import model.Student;
import model.StudentContainer;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import utils.Base64Utils;

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
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService
@SecurityDomain("student-domain")
@DeclareRoles({"developer", "user"})
@WebContext(authMethod="BASIC", transportGuarantee="NONE")
public class StudentController {

    //@Inject
    StudentContainer container;

    private static final String avatarPath = "././resources/avatar.png";

//    @WebMethod
//    @RolesAllowed("developer")
//    public Student addStudent(@WebParam(name = "indexNumber") final int indexNumber, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName,
//                              @WebParam(name = "age") int age, @WebParam(name = "courses") List<String> courses) {
//
//        Student newStudent = null;
//        if (container.getAll().stream().noneMatch(s -> s.getIndexNumber() == indexNumber)) {
//            newStudent = new Student(indexNumber, firstName, lastName, age, courses);
//            container.addStudent(newStudent);
//        }
//        return newStudent;
//
//    }
//
//    @WebMethod
//    @PermitAll
//    public Student updateStudent(@WebParam(name = "indexNumber") final int indexNumber, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName,
//                              @WebParam(name = "age") int age, @WebParam(name = "courses") List<String> courses) {
//        Student student = container.getAll().stream().filter(s -> s.getIndexNumber() == indexNumber).findFirst().orElse(null);
//
//        if (student == null) {
//            return null;
//        }
//
//        student.setAge(age);
//        student.setFirstName(firstName);
//        student.setLastName(lastName);
//        student.setCourses(courses);
//        return student;
//    }
//
//    @WebMethod
//    @PermitAll
//    @XmlElementWrapper(name = "students")
//    @XmlElement(name = "student")
//    public List<Student> getStudentList() {
//        return container.getAll();
//    }
//
//    @WebMethod
//    @PermitAll
//    @XmlElement(name = "student")
//    public Student getStudentById(@WebParam(name = "indexNumber") int indexNumber) {
//        return container.getAll().stream().filter(s -> s.getIndexNumber() == indexNumber).findFirst().orElse(null);
//    }
//
//    @WebMethod
//    @PermitAll
//    @XmlElementWrapper(name = "students")
//    @XmlElement(name = "student")
//    public List<Student> getStudentsByAge(@WebParam(name = "age") int age) {
//        return container.getAll().stream().filter(s -> s.getAge() == age).collect(Collectors.toList());
//    }
//
//    @WebMethod
//    @PermitAll
//    @XmlElementWrapper(name = "students")
//    @XmlElement(name = "student")
//    public List<Student> getStudentsByFirstName(@WebParam(name = "firstName") String firstName) {
//        return container.getAll().stream().filter(s -> s.getFirstName().equals(firstName)).collect(Collectors.toList());
//    }
//
//    @XmlElementWrapper(name = "students")
//    @XmlElement(name = "student")
//    @WebMethod
//    @PermitAll
//    public List<Student> getStudentsByLastName(@WebParam(name = "lastName") String lastName) {
//        return container.getAll().stream().filter(s -> s.getLastName().equals(lastName)).collect(Collectors.toList());
//    }
//
//    @XmlElementWrapper(name = "students")
//    @XmlElement(name = "student")
//    @WebMethod
//    @PermitAll
//    public List<Student> getStudentsByCourse(@WebParam(name = "course") String course) {
//        return container.getAll().stream().filter(s -> s.getCourses().contains(course)).collect(Collectors.toList());
//    }
//
//    @WebMethod
//    @PermitAll
//    public String getAvatar() {
//        return Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png");
//    }
}
