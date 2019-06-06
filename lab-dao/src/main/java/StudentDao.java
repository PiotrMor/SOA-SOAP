import model.Avatar;
import model.Student;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Stateless
public class StudentDao extends AbstractDao{
    @Override
    protected Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentJPA> getType() {
        return StudentJPA.class;
    }
    public void add(Student student) {
        StudentMapper sm = new StudentMapper();

        StudentJPA studentRepository = sm.DTOtoEntity(student);
        getLogger().info(studentRepository.toString());
        this.create(studentRepository);
    }

    public boolean update(int id, Student student) {
        StudentMapper sm = new StudentMapper();

        StudentJPA studentRepository = sm.DTOtoEntity(student);

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

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        q.select(c);

        TypedQuery<StudentJPA> query = entityManager.createQuery(q);

        List<StudentJPA> results = query.getResultList();

        System.out.println(results);

        StudentMapper sm = new StudentMapper();

        return sm.EntitytoDTO(results);
    }

    public List<Student> getAll(Map<String, String> params) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        Join<StudentJPA, AddressJPA> address = c.join("address", JoinType.LEFT);
        Join<StudentJPA, CourseJPA> course = c.join("courses", JoinType.LEFT);
        Join<CourseJPA, LecturerJPA> lecturer = course.join("lecturer", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();


        for (Map.Entry<String, String> param: params.entrySet()) {
            if (param.getKey().contains("course")) {
                predicates.add(cb.equal(course.get(getCorrectTableName(param.getKey())), param.getValue()));
            } else if(param.getKey().contains("lecturer"))  {
                predicates.add(cb.equal(lecturer.get(getCorrectTableName(param.getKey())), param.getValue()));
            } else if(param.getKey().contains("address"))  {
                predicates.add(cb.equal(address.get(getCorrectTableName(param.getKey())), param.getValue()));
            } else {
                predicates.add(cb.equal(c.get(param.getKey()), param.getValue() ));
            }
        }


        q.select(c).distinct(true).where(predicates.toArray(new Predicate[]{}));



        List<StudentJPA> results = entityManager.createQuery(q).getResultList();

        StudentMapper sm = new StudentMapper();

        return sm.EntitytoDTO(results);
    }

    public List<Student> getAllByLastName(String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        getLogger().info("Parameter" + p);

        q.select(c).where(cb.equal(c.get("lastName"), p));

        TypedQuery<StudentJPA> query = entityManager.createQuery(q);
        query.setParameter(p, lastName);

        List<StudentJPA> results = query.getResultList();

        StudentMapper sm = new StudentMapper();

        return sm.EntitytoDTO(results);
    }

    public List<Student> getAllByCourseName(String courseName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        Join<StudentJPA, CourseJPA> course = c.join("courses", JoinType.LEFT);

        Predicate predicate = cb.equal(course.get("name"), p);

        q.select(c).distinct(true).where(predicate);

        TypedQuery<StudentJPA> query = entityManager.createQuery(q);
        query.setParameter(p, courseName);

        List<StudentJPA> results = query.getResultList();

        StudentMapper sm = new StudentMapper();

        return sm.EntitytoDTO(results);
    }

    public Student getOne(Integer id) {
        StudentMapper sm = new StudentMapper();

        StudentJPA studentRepository = this.entityManager.find(StudentJPA.class, id);

        return sm.EntitytoDTO(studentRepository);
    }

    public void addAvatar(Avatar avatar) {
        StudentMapper sm = new StudentMapper();

        AvatarJPA avatarRepository = sm.DTOtoEntity(avatar);

        this.create(avatarRepository);
    }

    private String getCorrectTableName(String s) {
        if (!s.contains("_")) {
            return s;
        }
        return s.substring(s.indexOf("_") + 1);
    }

}
