package model.service;

import model.dto.StudentRequesDto;
import model.dto.StudentResponDto;

import java.util.List;

public interface StudentService {

    StudentResponDto createStudent(StudentRequesDto responDto);
    List<StudentResponDto> getAllStudent();
    boolean removeById(Long id);
}
