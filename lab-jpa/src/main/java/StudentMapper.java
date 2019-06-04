import model.Avatar;
import model.Student;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {
    public StudentJPA DTOtoEntity(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentJPA.class);
    }

    public Student EntitytoDTO(StudentJPA studentRepository) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentRepository, Student.class);
    }

    public List<Student> EntitytoDTO(List<StudentJPA> studentRepositories) {
        final ModelMapper modelMapper = new ModelMapper();
        return studentRepositories.stream().map(s -> modelMapper.map(s, Student.class)).collect(Collectors.toList());
    }

    public List<StudentJPA> DTOtoEntity(List<Student> students) {
        final ModelMapper modelMapper = new ModelMapper();
        return students.stream().map(s -> modelMapper.map(s, StudentJPA.class)).collect(Collectors.toList());
    }

    public AvatarJPA DTOtoEntity(Avatar student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, AvatarJPA.class);
    }

    public Avatar EntitytoDTO(AvatarJPA avatarRepository) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(avatarRepository, Avatar.class);
    }
}
