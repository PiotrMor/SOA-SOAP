import api.StudentController;
import auth.JWTTokenNeededFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class StudentApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(StudentController.class);
        classes.add(JWTTokenNeededFilter.class);
        return classes;
    }
}
