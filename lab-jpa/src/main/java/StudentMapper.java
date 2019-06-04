import model.Avatar;
import model.Student;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {
    public StudentRepository DTOtoEntity(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentRepository.class);
    }

    public Student EntitytoDTO(StudentRepository studentRepository) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentRepository, Student.class);
    }

    public List<Student> EntitytoDTO(List<StudentRepository> studentRepositories) {
        final ModelMapper modelMapper = new ModelMapper();
        return studentRepositories.stream().map(s -> modelMapper.map(s, Student.class)).collect(Collectors.toList());
    }

    public List<StudentRepository> DTOtoEntity(List<Student> students) {
        final ModelMapper modelMapper = new ModelMapper();
        return students.stream().map(s -> modelMapper.map(s, StudentRepository.class)).collect(Collectors.toList());
    }

    public AvatarRepository DTOtoEntity(Avatar student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, AvatarRepository.class);
    }

    public Avatar EntitytoDTO(AvatarRepository avatarRepository) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(avatarRepository, Avatar.class);
    }
}
