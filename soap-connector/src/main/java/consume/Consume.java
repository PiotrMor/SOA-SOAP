package consume;


import client.Student;
import client.StudentController;
import client.StudentControllerService;

import javax.xml.ws.BindingProvider;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Consume {

    public static void main(String[] args) {
        StudentControllerService service = new StudentControllerService();
        StudentController test = service.getStudentControllerPort();

        setCredentials((BindingProvider) test, "qwe", "asd");

        List<String> courses = new ArrayList<String>() {
            {
                add("maths");
            }
        };

        printStudent(test.addStudent(123422, "Piotr", "Morawiecki", 12, courses));

        courses.add("SOA");
        printStudent(test.addStudent(123421, "Maciej", "Stępień", 32, courses));

        courses.add("computer science");
        printStudent(test.addStudent(123424, "Karol", "Kowalski", 21, courses));

        printStudentList(test.getStudentList().getStudent());

        printStudentList(test.getStudentsByFirstName("Piotr").getStudent());

        decoder(test.getAvatar(), "avatar.png");

        try {
            Runtime.getRuntime().exec("shotwell avatar.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setCredentials(BindingProvider provider, String user, String password) {
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, user);
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    }


    private static void decoder(String base64Image, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            fos.write(imageByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printStudent(Student student) {
        if (student != null) {
            System.out.println("Student{" +
                    "indexNumber=" + student.getIndexNumber() +
                    ", firstName='" + student.getFirstName() + '\'' +
                    ", lastName='" + student.getLastName() + '\'' +
                    ", age=" + student.getAge() +
                    ", courses=" + student.getCourses().getCourse() +
                    '}');
        }
    }

    private static void printStudentList(List<Student> students) {
        System.out.println("Lista studentów:");
        students.forEach(Consume::printStudent);
    }
}
