package db;

import model.entities.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDb {
    List<Student> studentList ;
    public StudentDb() {
        studentList = new ArrayList<>() {{
            add(new Student("Vin Van", Student.Gender.MALE, LocalDate.now().minusYears(20)));

            add(new Student("Van dara", Student.Gender.FEMALE, LocalDate.now().minusYears(30)));

            add(new Student("Ban Bona", Student.Gender.FEMALE, LocalDate.now().minusYears(25)));
            add(new Student("Ban vanda", Student.Gender.FEMALE, LocalDate.now().minusYears(25)));

            add(new Student("Hong Da", Student.Gender.FEMALE, LocalDate.now().minusYears(40)));

        }};
    }

    public List<Student> getStudentList(){
        return studentList;
    }
}

