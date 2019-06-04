package consume;

import model.*;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import utils.Base64Utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Consume {
    private static final String URL = "http://localhost:8080/lab-web/student";

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("soa", 4, new Lecturer("Kowalski")));
        String jwtToken = login("qwe", "asd");
        courses.add(new Course("java",3, new Lecturer("Nowak")));

        Address address = new Address("Budryka", "Krakow");

        Student s1 = new Student(123123, "Karol", "Kowalski",address, courses);
        Student s2 = new Student(213123, "Łukasz", "Polak",address, courses);
        Student s3 = new Student(223123, "Łukasz", "Polak",address, courses);

        deleteStudent(123123, jwtToken);
        deleteStudent(213123, jwtToken);
        deleteStudent(223123, jwtToken);


        System.out.println(addStudent(s1, jwtToken));

        System.out.println(addStudent(s2, jwtToken));
        courses.add(new Course("c++", 5, new Lecturer("Fatyga")));
        System.out.println(addStudent(s3, jwtToken));

        System.out.println("-----STUDENTS WITH COURSE c++-----");
        System.out.println(getStudentList("courseName", "c++"));
        System.out.println("-----STUDENTS WITH LASTNAME = Polak-----");
        System.out.println(getStudentList("lastName","Polak"));
        System.out.println("-----ALL STUDENTS-----");
        System.out.println(getStudentList());

        deleteStudent(123123, jwtToken);
        System.out.println("-----ONE STUDENT DELETED-----");
        System.out.println(getStudentList());

        s2.setFirstName("Kacper");

        updateStudent(s2, jwtToken);
        System.out.println("-----UPDATE STUDENT WITH ID 213123");
        System.out.println(getStudent(s2.getIndexNumber()));



        /*s1.setLastName("Nowak");

        System.out.println(updateStudent(s1, jwtToken));

        System.out.println(getStudent(123123));

        System.out.println(deleteStudent(123123, jwtToken));

        System.out.println(getStudentList());*/



    }

    private static Student getStudent(int id) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target.path(id + "").request().get();
        System.out.println(response.getStatus());
        Student student = null;
        if (response.getStatus() == 200) {
            student = response.readEntity(Student.class);
        }
        client.close();
        return student;
    }

    private static List<Student> getStudentList(String query, String value) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target
                .queryParam(query, value)
                .request()
                .get();
        List<Student> students = response.readEntity(new GenericType<List<Student>>() {});
        client.close();
        return students;
    }


    private static List<Student> getStudentList() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target.request().get();
        List<Student> students = response.readEntity(new GenericType<List<Student>>() {});
        client.close();
        return students;
    }

    private static int addStudent(Student student, String token) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target
                .request()
                .header("Authorization", token)
                .post(Entity.entity(student, MediaType.APPLICATION_JSON ));
        client.close();
        return response.getStatus();
    }

    private static int deleteStudent(int id, String token) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target
                .path(id + "")
                .request()
                .header("Authorization", token)
                .delete();
        client.close();
        return response.getStatus();
    }

    private static int updateStudent(Student student, String token) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);
        Response response = target
                .path(student.getIndexNumber() + "")
                .request()
                .header("Authorization", token)
                .put(Entity.entity(student, MediaType.APPLICATION_JSON ));
        client.close();
        return response.getStatus();
    }

    private static void getAvatar() {
        Client client = new ResteasyClientBuilder().build();
        WebTarget target = client.target(URL);
        Response response = target.path("avatar").request().get();
        String codedAvatar = response.readEntity(String.class);
        client.close();
        Base64Utils.decoder(codedAvatar, "rest_avatar.png");
        try {
            Runtime.getRuntime().exec("shotwell rest_avatar.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String login(String login, String password) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);

        Form form = new Form();
        form.param("login", login).param("password", password);
        Response response = target
                .path("login")
                .request()
                .post(Entity.form(form));
        client.close();

        return response.getHeaderString("Authorization");
    }

    private static String getProto() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);

        InputStream response = target
                .path("proto")
                .request()
                .header("accept", MediaType.APPLICATION_OCTET_STREAM)
                .get(InputStream.class);

        try {
            StudentProto.Student student = StudentProto.Student.parseFrom(IOUtils.toByteArray(response));
            return student.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
