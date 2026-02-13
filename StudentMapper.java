package mapper;

import model.dto.StudentRequesDto;
import model.dto.StudentResponDto;
import model.entities.Student;

public class StudentMapper {

    public Student fromStudentRequesDto(StudentRequesDto requesDto) {
        return new Student(
                requesDto.fullName(),
                Student.Gender.valueOf(requesDto.gender().toUpperCase()),
                requesDto.dateOfBirth()
        );

    }

    public StudentResponDto toStudentResponDto(Student student){
        return StudentResponDto.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .gender(student.getGender().toString())
                .datOfBirth(student.getDateOfBirth())
                .build();
    }
}
