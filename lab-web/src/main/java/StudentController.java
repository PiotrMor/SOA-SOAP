import auth.JWTTokenNeeded;
import auth.KeyGenerator;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import model.Avatar;
import model.Student;
import model.StudentContainer;
import model.StudentProto;
import utils.Base64Utils;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Logger;

@Path("student")
@Api(value = "student")
public class StudentController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @EJB
    StudentDao studentDao;

    @EJB
    AvatarDao avatarDao;


    @Context
    UriInfo uriInfo;

    @Inject
    private KeyGenerator keyGenerator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentList(@QueryParam("lastName") String lastNameFilter,
                                   @QueryParam("course_name") String courseNameFilter) {
        List<Student> students;
        Map<String, String> params = new HashMap<>();

        if (courseNameFilter != null) {
            params.put("lastName", lastNameFilter);
        }
         if (lastNameFilter != null) {
            params.put("course_name", courseNameFilter);
        }
         if (params.isEmpty()) {
             students = studentDao.getAll();
         } else {
             students = studentDao.getAll(params);
         }
        return Response.ok(students).status(Response.Status.OK).build();
    }


    @GET
    @Path("/{id}")
    @ApiOperation(value = "Get student by id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") int indexNumber) {
        Student student = studentDao.getOne(indexNumber);

        if (student != null) {
            return Response.ok(student).status(Response.Status.OK).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @ApiOperation(value = "Add new student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTTokenNeeded
    public Response addStudent(Student student) {
        if (studentDao.getAll().stream().noneMatch(s -> s.getIndexNumber() == student.getIndexNumber())) {
            studentDao.add(student);
            return Response.ok(student).status(Response.Status.OK).build();
        } else {
            return Response.notModified().status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value = "Update student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@JWTTokenNeeded
    public Response editStudent(@PathParam("id") int indexNumber, @Valid Student student) {
        return Response.ok().status(Response.Status.OK).entity(studentDao.update(indexNumber, student)).build();
    }

    @DELETE
    @ApiOperation(value = "Remove student")
    @Path("/{id}")
    //@JWTTokenNeeded
    public Response deleteStudent(@PathParam("id") int indexNumber) {
        if (studentDao.deleteStudent(indexNumber)) {
            return Response.ok().status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @ApiOperation(value = "Returns avatar in Base64")
    @Path("/avatar")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAvatar(int indexNumber) {
        return Response.status(Response.Status.OK).entity(avatarDao.getAvatar(indexNumber)).build();
    }

    @POST
    @Path("/avatar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAvatar(int indexNumber) {
        Avatar avatar =
                new Avatar(Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png"),
                        indexNumber);
        avatarDao.addAvatar(avatar);
        return Response.status(Response.Status.OK).entity(avatar).build();
    }

    @POST
    @ApiOperation(value = "Login to get token")
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("login") String login, @FormParam("password") String password) {
        try {
            String token = issueToken(login);

            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key)
                .compact();
        return jwtToken;
    }

/*    @GET
    @Path("/proto")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getProtoStudent() {
        StudentProto.Student.Builder builder = StudentProto.Student.newBuilder();

        List<String> courses = new ArrayList<>();
        courses.add("SOA");
        courses.add("JAVA");
        builder.addAllCourses(courses);
        builder
                .setAge(21)
                .setFirstName("Rafal")
                .setLastName("Stepien")
                .setIndexNumber(312521);
        StudentProto.Student student = builder.build();

        return Response.ok(student.toByteArray(), MediaType.APPLICATION_OCTET_STREAM).build();
    }*/
}
