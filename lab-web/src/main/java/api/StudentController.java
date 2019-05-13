package api;





import auth.JWTTokenNeeded;
import auth.KeyGenerator;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import model.Student;
import model.StudentContainer;
import model.StudentProto;
import utils.Base64Utils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("student")
@Api(value = "student")
public class StudentController {

    @Inject
    StudentContainer container;

    @Context
    UriInfo uriInfo;

    @Inject
    private KeyGenerator keyGenerator;

    @GET
    @ApiOperation(value = "List students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentList() {
        return Response.ok(container.getAll()).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Get student by id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") int indexNumber) {
        Student student = container.getAll().stream().filter(s -> s.getIndexNumber()==indexNumber).findFirst().orElse(null);

        if (student != null) {
            return Response.ok(student).status(Response.Status.OK).build();
        }

        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @ApiOperation(value = "Add new student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response addStudent(Student student) {
        if (container.getAll().stream().noneMatch(s -> s.getIndexNumber() == student.getIndexNumber())){
            container.addStudent(student);
            return Response.ok(student).status(Response.Status.OK).build();
        }
        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @ApiOperation(value = "Update student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response editStudent(final Student student) {
        Student editStudent = container
                .getAll()
                .stream()
                .filter(s -> s.getIndexNumber() == student.getIndexNumber())
                .findFirst()
                .orElse(null);

        if (editStudent == null) {
            return Response.notModified().status(Response.Status.BAD_REQUEST).build();
        }

        editStudent.setAge(student.getAge());
        editStudent.setFirstName(student.getFirstName());
        editStudent.setLastName(student.getLastName());
        editStudent.setCourses(student.getCourses());

        return Response.ok(editStudent).status(Response.Status.OK).build();
    }

    @DELETE
    @ApiOperation(value = "Remove student")
    @Path("/{id}")
    @JWTTokenNeeded
    public Response deleteStudent(@PathParam("id") int indexNumber) {
        if (container.deleteStudent(indexNumber)) {
            return Response.ok().status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @ApiOperation(value = "Returns avatar in Base64")
    @Path("/avatar")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAvatar() {
        return Response.ok(Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png"))
                .status(Response.Status.OK).build();
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

    @GET
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
                .setFirstName("Rafał")
                .setLastName("Stępień")
                .setId(312521);
        StudentProto.Student student = builder.build();

        return Response.ok(student.toByteArray(), MediaType.APPLICATION_OCTET_STREAM).build();
    }
}
