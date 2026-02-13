package model.service;

import exseption.StudentExseption;
import mapper.StudentMapper;
import model.deo.StudentDeo;
import model.dto.StudentRequesDto;
import model.dto.StudentResponDto;
import model.entities.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentServicempl implements StudentService{

    private StudentDeo deo;
    private StudentMapper mapper;

    public StudentServicempl (StudentDeo deo   ,StudentMapper mapper){
        this.deo = deo;
        this.mapper = mapper;
    }
    @Override
    public StudentResponDto createStudent(StudentRequesDto responDto) {
        if (responDto.dateOfBirth().isAfter(LocalDate.now().minusYears(4))){
            throw new StudentExseption("Student hasn't born yet!");
        }
        Student student = mapper.fromStudentRequesDto(responDto);
        Student savStudent = deo.save(student);
        return mapper.toStudentResponDto(savStudent);
    }

    @Override
    public List<StudentResponDto> getAllStudent() {
        return deo.geAll().stream().map(mapper::toStudentResponDto).toList();
    }

    @Override
    public boolean removeById(Long id) {
        return deo.removeById(id);
    }
}
