
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStudentById_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentById");
    private final static QName _GetStudentsByCourseResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByCourseResponse");
    private final static QName _GetStudentsByFirstName_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByFirstName");
    private final static QName _GetStudentsByCourse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByCourse");
    private final static QName _GetStudentsByLastNameResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByLastNameResponse");
    private final static QName _AddStudentResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _GetStudentsByFirstNameResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByFirstNameResponse");
    private final static QName _GetAvatarResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getAvatarResponse");
    private final static QName _Student_QNAME = new QName("http://api.soa.agh.edu.pl/", "student");
    private final static QName _UpdateStudentResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "updateStudentResponse");
    private final static QName _GetStudentList_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentList");
    private final static QName _GetStudentsByAgeResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByAgeResponse");
    private final static QName _GetAvatar_QNAME = new QName("http://api.soa.agh.edu.pl/", "getAvatar");
    private final static QName _UpdateStudent_QNAME = new QName("http://api.soa.agh.edu.pl/", "updateStudent");
    private final static QName _AddStudent_QNAME = new QName("http://api.soa.agh.edu.pl/", "addStudent");
    private final static QName _GetStudentsByAge_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByAge");
    private final static QName _GetStudentListResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentListResponse");
    private final static QName _GetStudentsByLastName_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByLastName");
    private final static QName _GetStudentByIdResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentsByLastNameResponse }
     * 
     */
    public GetStudentsByLastNameResponse createGetStudentsByLastNameResponse() {
        return new GetStudentsByLastNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByFirstNameResponse }
     * 
     */
    public GetStudentsByFirstNameResponse createGetStudentsByFirstNameResponse() {
        return new GetStudentsByFirstNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByCourseResponse }
     * 
     */
    public GetStudentsByCourseResponse createGetStudentsByCourseResponse() {
        return new GetStudentsByCourseResponse();
    }

    /**
     * Create an instance of {@link GetStudentListResponse }
     * 
     */
    public GetStudentListResponse createGetStudentListResponse() {
        return new GetStudentListResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentsByAgeResponse }
     * 
     */
    public GetStudentsByAgeResponse createGetStudentsByAgeResponse() {
        return new GetStudentsByAgeResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link GetStudentsByAge }
     * 
     */
    public GetStudentsByAge createGetStudentsByAge() {
        return new GetStudentsByAge();
    }

    /**
     * Create an instance of {@link GetStudentList }
     * 
     */
    public GetStudentList createGetStudentList() {
        return new GetStudentList();
    }

    /**
     * Create an instance of {@link GetAvatarResponse }
     * 
     */
    public GetAvatarResponse createGetAvatarResponse() {
        return new GetAvatarResponse();
    }

    /**
     * Create an instance of {@link UpdateStudentResponse }
     * 
     */
    public UpdateStudentResponse createUpdateStudentResponse() {
        return new UpdateStudentResponse();
    }

    /**
     * Create an instance of {@link GetAvatar }
     * 
     */
    public GetAvatar createGetAvatar() {
        return new GetAvatar();
    }

    /**
     * Create an instance of {@link UpdateStudent }
     * 
     */
    public UpdateStudent createUpdateStudent() {
        return new UpdateStudent();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByLastName }
     * 
     */
    public GetStudentsByLastName createGetStudentsByLastName() {
        return new GetStudentsByLastName();
    }

    /**
     * Create an instance of {@link GetStudentsByFirstName }
     * 
     */
    public GetStudentsByFirstName createGetStudentsByFirstName() {
        return new GetStudentsByFirstName();
    }

    /**
     * Create an instance of {@link GetStudentById }
     * 
     */
    public GetStudentById createGetStudentById() {
        return new GetStudentById();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByCourse }
     * 
     */
    public GetStudentsByCourse createGetStudentsByCourse() {
        return new GetStudentsByCourse();
    }

    /**
     * Create an instance of {@link GetStudentsByLastNameResponse.Students }
     * 
     */
    public GetStudentsByLastNameResponse.Students createGetStudentsByLastNameResponseStudents() {
        return new GetStudentsByLastNameResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentsByFirstNameResponse.Students }
     * 
     */
    public GetStudentsByFirstNameResponse.Students createGetStudentsByFirstNameResponseStudents() {
        return new GetStudentsByFirstNameResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentsByCourseResponse.Students }
     * 
     */
    public GetStudentsByCourseResponse.Students createGetStudentsByCourseResponseStudents() {
        return new GetStudentsByCourseResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentListResponse.Students }
     * 
     */
    public GetStudentListResponse.Students createGetStudentListResponseStudents() {
        return new GetStudentListResponse.Students();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link GetStudentsByAgeResponse.Students }
     * 
     */
    public GetStudentsByAgeResponse.Students createGetStudentsByAgeResponseStudents() {
        return new GetStudentsByAgeResponse.Students();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentById")
    public JAXBElement<GetStudentById> createGetStudentById(GetStudentById value) {
        return new JAXBElement<GetStudentById>(_GetStudentById_QNAME, GetStudentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByCourseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByCourseResponse")
    public JAXBElement<GetStudentsByCourseResponse> createGetStudentsByCourseResponse(GetStudentsByCourseResponse value) {
        return new JAXBElement<GetStudentsByCourseResponse>(_GetStudentsByCourseResponse_QNAME, GetStudentsByCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFirstName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByFirstName")
    public JAXBElement<GetStudentsByFirstName> createGetStudentsByFirstName(GetStudentsByFirstName value) {
        return new JAXBElement<GetStudentsByFirstName>(_GetStudentsByFirstName_QNAME, GetStudentsByFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByCourse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByCourse")
    public JAXBElement<GetStudentsByCourse> createGetStudentsByCourse(GetStudentsByCourse value) {
        return new JAXBElement<GetStudentsByCourse>(_GetStudentsByCourse_QNAME, GetStudentsByCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByLastNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByLastNameResponse")
    public JAXBElement<GetStudentsByLastNameResponse> createGetStudentsByLastNameResponse(GetStudentsByLastNameResponse value) {
        return new JAXBElement<GetStudentsByLastNameResponse>(_GetStudentsByLastNameResponse_QNAME, GetStudentsByLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFirstNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByFirstNameResponse")
    public JAXBElement<GetStudentsByFirstNameResponse> createGetStudentsByFirstNameResponse(GetStudentsByFirstNameResponse value) {
        return new JAXBElement<GetStudentsByFirstNameResponse>(_GetStudentsByFirstNameResponse_QNAME, GetStudentsByFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getAvatarResponse")
    public JAXBElement<GetAvatarResponse> createGetAvatarResponse(GetAvatarResponse value) {
        return new JAXBElement<GetAvatarResponse>(_GetAvatarResponse_QNAME, GetAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "updateStudentResponse")
    public JAXBElement<UpdateStudentResponse> createUpdateStudentResponse(UpdateStudentResponse value) {
        return new JAXBElement<UpdateStudentResponse>(_UpdateStudentResponse_QNAME, UpdateStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentList")
    public JAXBElement<GetStudentList> createGetStudentList(GetStudentList value) {
        return new JAXBElement<GetStudentList>(_GetStudentList_QNAME, GetStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByAgeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByAgeResponse")
    public JAXBElement<GetStudentsByAgeResponse> createGetStudentsByAgeResponse(GetStudentsByAgeResponse value) {
        return new JAXBElement<GetStudentsByAgeResponse>(_GetStudentsByAgeResponse_QNAME, GetStudentsByAgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getAvatar")
    public JAXBElement<GetAvatar> createGetAvatar(GetAvatar value) {
        return new JAXBElement<GetAvatar>(_GetAvatar_QNAME, GetAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "updateStudent")
    public JAXBElement<UpdateStudent> createUpdateStudent(UpdateStudent value) {
        return new JAXBElement<UpdateStudent>(_UpdateStudent_QNAME, UpdateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByAge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByAge")
    public JAXBElement<GetStudentsByAge> createGetStudentsByAge(GetStudentsByAge value) {
        return new JAXBElement<GetStudentsByAge>(_GetStudentsByAge_QNAME, GetStudentsByAge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentListResponse")
    public JAXBElement<GetStudentListResponse> createGetStudentListResponse(GetStudentListResponse value) {
        return new JAXBElement<GetStudentListResponse>(_GetStudentListResponse_QNAME, GetStudentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByLastName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByLastName")
    public JAXBElement<GetStudentsByLastName> createGetStudentsByLastName(GetStudentsByLastName value) {
        return new JAXBElement<GetStudentsByLastName>(_GetStudentsByLastName_QNAME, GetStudentsByLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentByIdResponse")
    public JAXBElement<GetStudentByIdResponse> createGetStudentByIdResponse(GetStudentByIdResponse value) {
        return new JAXBElement<GetStudentByIdResponse>(_GetStudentByIdResponse_QNAME, GetStudentByIdResponse.class, null, value);
    }

}
