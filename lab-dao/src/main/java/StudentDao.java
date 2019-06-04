import model.Avatar;
import model.Student;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.security.acl.Owner;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class StudentDao extends AbstractDao{
    @Override
    protected Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentRepository> getType() {
        return StudentRepository.class;
    }
    public void add(Student student) {
        StudentMapper sm = new StudentMapper();

        StudentRepository studentRepository = sm.DTOtoEntity(student);
        getLogger().info(studentRepository.toString());
        this.create(studentRepository);
    }

    public boolean update(int id, Student student) {
        StudentMapper sm = new StudentMapper();

        StudentRepository studentRepository = sm.DTOtoEntity(student);

        if (this.getOne(id) != null) {
            studentRepository.setIndexNumber(id);
            this.update(studentRepository);
            return true;
        }

        return false;
    }

    public boolean deleteStudent(Integer id) {
        if (this.getOne(id) != null) {
            this.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentRepository> q = cb.createQuery(StudentRepository.class);
        Root<StudentRepository> c = q.from(StudentRepository.class);
        q.select(c);

        TypedQuery<StudentRepository> query = entityManager.createQuery(q);

        List<StudentRepository> results = query.getResultList();

        System.out.println(results);

        StudentMapper sm = new StudentMapper();

        return sm.EntitytoDTO(results);
    }

    public List<Student> getAllByLastName(String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentRepository> q = cb.createQuery(StudentRepository.class);
        Root<StudentRepository> c = q.from(StudentRepository.class);
        ParameterExpression<String> p = cb.parameter(String.class);

        q.select(c).where(cb.equal(c.get("lastName"), p));

        TypedQuery<StudentRepository> query = entityManager.createQuery(q);
        query.setParameter(p, lastName);

        List<StudentRepository> results = query.getResultList();

        StudentMapper sm = new StudentMapper();

        return sm.EntitytoDTO(results);
    }

    public List<Student> getAllByCourseName(String CourseName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentRepository> q = cb.createQuery(StudentRepository.class);
        Root<StudentRepository> c = q.from(StudentRepository.class);
        Join<StudentRepository, CourseRepository> course = c.join()

        return sm.EntitytoDTO(results);
    }

    public Student getOne(Integer id) {
        StudentMapper sm = new StudentMapper();

        StudentRepository studentRepository = this.entityManager.find(StudentRepository.class, id);

        return sm.EntitytoDTO(studentRepository);
    }

    public void addAvatar(Avatar avatar) {
        StudentMapper sm = new StudentMapper();

        AvatarRepository avatarRepository = sm.DTOtoEntity(avatar);

        this.create(avatarRepository);
    }

}
