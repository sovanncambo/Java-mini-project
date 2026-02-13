package model.deo;

import model.entities.Student;

import java.util.List;

public interface StudentDeo {
    Student save(Student student);
    List<Student> geAll();

    boolean removeById(Long id);
}
