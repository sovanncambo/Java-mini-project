package model.deo;

import model.entities.Student;
import db.StudentDb;

import java.util.List;

public class StudentDeoImpl implements StudentDeo{
    private  final StudentDb studentdb;

    public StudentDeoImpl(StudentDb studentDb){
        this.studentdb = studentDb;
    }

    @Override
    public Student save(Student student) {
        studentdb.getStudentList().add(student);
        return student;
    }

    @Override
    public List<Student> geAll() {
        return studentdb.getStudentList();
    }

    @Override
    public boolean removeById(Long id) {
            return studentdb.getStudentList().removeIf(student -> student.getId().equals(id));
    }
}
