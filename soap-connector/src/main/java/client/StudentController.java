
package client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentController", targetNamespace = "http://api.soa.agh.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentController {


    /**
     * 
     * @param indexNumber
     * @return
     *     returns client.Student
     */
    @WebMethod
    @WebResult(name = "student", targetNamespace = "")
    @RequestWrapper(localName = "getStudentById", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentById")
    @ResponseWrapper(localName = "getStudentByIdResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentByIdResponse")
    public Student getStudentById(
        @WebParam(name = "indexNumber", targetNamespace = "")
        int indexNumber);

    /**
     * 
     * @return
     *     returns client.GetStudentListResponse.Students
     */
    @WebMethod
    @WebResult(name = "students", targetNamespace = "")
    @RequestWrapper(localName = "getStudentList", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentList")
    @ResponseWrapper(localName = "getStudentListResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentListResponse")
    public client.GetStudentListResponse.Students getStudentList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAvatar", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetAvatar")
    @ResponseWrapper(localName = "getAvatarResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetAvatarResponse")
    public String getAvatar();

    /**
     * 
     * @param firstName
     * @param lastName
     * @param courses
     * @param indexNumber
     * @param age
     * @return
     *     returns client.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateStudent", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.UpdateStudent")
    @ResponseWrapper(localName = "updateStudentResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.UpdateStudentResponse")
    public Student updateStudent(
        @WebParam(name = "indexNumber", targetNamespace = "")
        int indexNumber,
        @WebParam(name = "firstName", targetNamespace = "")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "")
        String lastName,
        @WebParam(name = "age", targetNamespace = "")
        int age,
        @WebParam(name = "courses", targetNamespace = "")
        List<String> courses);

    /**
     * 
     * @param firstName
     * @param lastName
     * @param courses
     * @param indexNumber
     * @param age
     * @return
     *     returns client.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.AddStudentResponse")
    public Student addStudent(
        @WebParam(name = "indexNumber", targetNamespace = "")
        int indexNumber,
        @WebParam(name = "firstName", targetNamespace = "")
        String firstName,
        @WebParam(name = "lastName", targetNamespace = "")
        String lastName,
        @WebParam(name = "age", targetNamespace = "")
        int age,
        @WebParam(name = "courses", targetNamespace = "")
        List<String> courses);

    /**
     * 
     * @param age
     * @return
     *     returns client.GetStudentsByAgeResponse.Students
     */
    @WebMethod
    @WebResult(name = "students", targetNamespace = "")
    @RequestWrapper(localName = "getStudentsByAge", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByAge")
    @ResponseWrapper(localName = "getStudentsByAgeResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByAgeResponse")
    public client.GetStudentsByAgeResponse.Students getStudentsByAge(
        @WebParam(name = "age", targetNamespace = "")
        int age);

    /**
     * 
     * @param firstName
     * @return
     *     returns client.GetStudentsByFirstNameResponse.Students
     */
    @WebMethod
    @WebResult(name = "students", targetNamespace = "")
    @RequestWrapper(localName = "getStudentsByFirstName", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByFirstName")
    @ResponseWrapper(localName = "getStudentsByFirstNameResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByFirstNameResponse")
    public client.GetStudentsByFirstNameResponse.Students getStudentsByFirstName(
        @WebParam(name = "firstName", targetNamespace = "")
        String firstName);

    /**
     * 
     * @param course
     * @return
     *     returns client.GetStudentsByCourseResponse.Students
     */
    @WebMethod
    @WebResult(name = "students", targetNamespace = "")
    @RequestWrapper(localName = "getStudentsByCourse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByCourse")
    @ResponseWrapper(localName = "getStudentsByCourseResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByCourseResponse")
    public client.GetStudentsByCourseResponse.Students getStudentsByCourse(
        @WebParam(name = "course", targetNamespace = "")
        String course);

    /**
     * 
     * @param lastName
     * @return
     *     returns client.GetStudentsByLastNameResponse.Students
     */
    @WebMethod
    @WebResult(name = "students", targetNamespace = "")
    @RequestWrapper(localName = "getStudentsByLastName", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByLastName")
    @ResponseWrapper(localName = "getStudentsByLastNameResponse", targetNamespace = "http://api.soa.agh.edu.pl/", className = "client.GetStudentsByLastNameResponse")
    public client.GetStudentsByLastNameResponse.Students getStudentsByLastName(
        @WebParam(name = "lastName", targetNamespace = "")
        String lastName);

}
