package controlor;

import exseption.StudentExseption;
import model.dto.StudentRequesDto;
import model.dto.StudentResponDto;
import model.service.StudentService;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;
import view.StudentView;

import java.util.List;

public class StudentControler {

    private final StudentView view;
    private final StudentService service;

    public StudentControler(StudentView view,StudentService service){
        this.view = view;
        this.service = service;
    }

    public  void creat(){
        StudentRequesDto requesDto  = view.displayStudentCreateDto();
        StudentResponDto responDto = null;
        try {
            responDto = service.createStudent(requesDto);
        } catch (StudentExseption exseption) {
            System.out.println(exseption.getMessage());
        }
        assert responDto != null;
        view.displaySingleStuedent(responDto);
    }
    public void showAll(){
        view.desplayStudentList(service.getAllStudent());
    }

    public void delete(){
        Long id = view.showIdInput();
        if (service.removeById(id)){
            System.out.println("dete succesafully!!");
        }else {
            System.out.println("Fail to deleteb!");
        }
    }
    public void run(){
        while (true){
            int optio = view.showMenuAndGetOption();
            switch (optio){
                case 1->{
                   creat();
                   break;
                }

                case 2->{
                    showAll();
                    break;
                }

                case 3->{
                    delete();
                    break;
                }

                case 0->{
                    System.out.println("has been exet....!");
                    System.exit(0);
                }

            }
        }
    }
}
