package view;

import model.dto.StudentResponDto;
import model.dto.StudentRequesDto;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentView {

    private  final static  Scanner scanner = new Scanner(System.in);
    public StudentRequesDto displayStudentCreateDto(){
        System.out.print("[ + ] Enter Full name : ");
        String fullName = scanner.nextLine();

        System.out.print("[ + ] Enter gender    : ");
        String gender = scanner.nextLine();

        System.out.print("[ + ] Enter date of birth (YYY/MM/DD : ");
        String dob = scanner.nextLine();

        String[] part = dob.split("-");
        int year = Integer.parseInt(part[0]);
        int mont = Integer.parseInt(part[1]);
        int days = Integer.parseInt(part[2]);
        LocalDate dateOFBirth = LocalDate.of(year,mont,days);

        return new StudentRequesDto(fullName,gender,dateOFBirth);


    }

    public void displaySingleStuedent(StudentResponDto responDto){
        Table table = new Table(4, BorderStyle.CLASSIC);

        table.addCell("Student Information", new CellStyle(CellStyle.HorizontalAlign.center),4);
        table.addCell("ID");
        table.addCell(responDto.id().toString(),3);
        table.addCell("FullName");
        table.addCell(responDto.fullName(),3);
        table.addCell("Gender");
        table.addCell(responDto.gender(),3);
        table.addCell("Date of birth");
        table.addCell(responDto.datOfBirth().toString(),3);
        System.out.println(table.render());
    }

    public  void desplayStudentList(List<StudentResponDto> students){
        Table table = new Table(4, BorderStyle.CLASSIC);

        String[] columns = { "ID","FullName","Gender","DateOfBirth"};
        for (String column : columns){
            table.addCell(column);
        }
        students.forEach(student-> {
            table.addCell(student.id().toString());
            table.addCell(student.fullName());
            table.addCell(student.gender());
            table.addCell(student.datOfBirth().toString());
        });
        System.out.println(table.render());

    }

    public Long showIdInput(){
        System.out.print("Enter ID : ");
        return Long.parseLong(scanner.nextLine());
    }

    public  int showMenuAndGetOption(){
        System.out.println("""
                =============> Student Management <====================
                                [1] . Create
                                [2] . Show All
                                [3] . Deled
                                [0] . Exit 
                ========================================================
                """);
        System.out.print("\tChoose an option : ");
        return Integer.parseInt(scanner.nextLine());
    }
}
