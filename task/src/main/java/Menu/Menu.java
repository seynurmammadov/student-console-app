package Menu;

import Helper.Helper;
import Models.Student;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        Helper.titlePrint("Console application");
        System.out.println("- 1 Operation on students");
        System.out.println("- 2 Search");
        System.out.println("- 0 Get out of the system");
        Helper.printLine();
        Scanner scanner = Helper.generateScanner();
        try {
            int val = scanner.nextInt();
            switch (val){
                case 1:
                    operationOnSystem();
                    break;
                case 2:
                    Student.search();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    throw  new NullPointerException();
            }
        }catch (Exception e){
            Helper.errorNotify();
        }
        menu();
    }
    public static void operationOnSystem(){
        Helper.titlePrint("Operations on Students");
        System.out.println("- 1 Create Student");
        System.out.println("- 2 Edit Student");
        System.out.println("- 3 Delete Student by id");
        System.out.println("- 4 Show student by id");
        System.out.println("- 5 Show all students");
        System.out.println("- 0 Get out of the system");
        Helper.printLine();
        Scanner scanner = Helper.generateScanner();
        try {
            int val = scanner.nextInt();
            switch (val){
                case 1:
                    Student.create();
                    break;
                case 2:
                    Student.edit();
                    break;
                case 3:
                    Student.delete();
                    break;
                case 4:
                    Student.showByID();
                    break;
                case 5:
                    Student.showAll();
                    break;
                case 0:
                    break;
                default:
                    throw  new NullPointerException();
            }
        }catch (Exception e){
            Helper.errorNotify();
            return;
        }
        menu();
    }
}
