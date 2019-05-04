package api;





import model.Student;
import model.StudentContainer;
import utils.Base64Utils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("student")
public class StudentController {

    @Inject
    StudentContainer container;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentList() {
        return Response.ok(container.getAll()).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") int indexNumber) {
        Student student = container.getAll().stream().filter(s -> s.getIndexNumber()==indexNumber).findFirst().orElse(null);

        if (student != null) {
            return Response.ok(student).status(Response.Status.OK).build();
        }

        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student) {
        if (container.getAll().stream().noneMatch(s -> s.getIndexNumber() == student.getIndexNumber())){
            container.addStudent(student);
            return Response.ok(student).status(Response.Status.OK).build();
        }
        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int indexNumber) {
        if (container.deleteStudent(indexNumber)) {
            return Response.ok().status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/avatar")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAvatar() {
        return Response.ok(Base64Utils.encoder("/home/piotr/SOA/Zadanie1/lab/soap-api/src/main/resources/avatar.png"))
                .status(Response.Status.OK).build();
    }
}
