package Models;

import Helper.ConsoleReader;
import Helper.FileHelper;
import Helper.Helper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String lastName;
    private String email;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private Student(String name, String surname, String lastName, String email, String phoneNumber) throws IOException {
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.email=email;
        this.phoneNumber = phoneNumber;
        var file= FileHelper.readFile();
        this.id = Collections.max(file.keySet())+1;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\''
                ;
    }
    public static void create() throws IOException {
        System.out.println("Enter student name:");
        String name = ConsoleReader.readString();
        System.out.println("Enter student surname:");
        String surname = ConsoleReader.readString();
        System.out.println("Enter student last name:");
        String lastname = ConsoleReader.readString();
        System.out.println("Enter student email:");
        String email = ConsoleReader.readEmail();
        System.out.println("Enter student phone number:");
        String phoneNumber = ConsoleReader.readString();
        Student newStudent = new Student(name,surname,lastname,email,phoneNumber);
        addToJson(newStudent);
    }
    public static void edit() throws IOException {
        System.out.println("Enter student id:");
        HashMap<Integer,Student> studentList = FileHelper.readFile();
        int id = ConsoleReader.readNumber();
        Student student = studentList.get(id);
        if(student==null){
            throw new NullPointerException();
        }
        String str;
        System.out.println("1. Change for name");
        System.out.println("2. Change for surname");
        System.out.println("3. Change for lastname");
        System.out.println("4. Change for email");
        System.out.println("5. Change for phone number");
        int change = ConsoleReader.readNumber();
        switch (change){
            case 1:
                System.out.println("Enter new name:");
                str = ConsoleReader.readString();
                student.name=str;
                break;
            case 2:
                System.out.println("Enter new surname:");
                str = ConsoleReader.readString();
                student.surname=str;
                break;
            case 3:
                System.out.println("Enter new lastname:");
                str = ConsoleReader.readString();
                student.lastName=str;
                break;
            case 4:
                System.out.println("Enter new email:");
                str =ConsoleReader.readEmail();
                student.email= str;
                break;
            case 5:
                System.out.println("Enter new phone number:");
                str = ConsoleReader.readString();
                student.phoneNumber = str;
                break;
            default:
                throw new NullPointerException();
        }
        FileHelper.writeToFile(studentList);
    }
    public static void delete() throws IOException {
        System.out.println("Enter student id:");
        HashMap<Integer,Student> studentList = FileHelper.readFile();
        int id = ConsoleReader.readNumber();
        Student student = studentList.get(id);
        if(student==null){
            throw new NullPointerException();
        }
        studentList.remove(id);
        System.out.println("DELETED!");
        FileHelper.writeToFile(studentList);
    }
    public static void showByID() throws IOException {
        System.out.println("Enter student id:");
        HashMap<Integer,Student> studentList = FileHelper.readFile();
        int id = ConsoleReader.readNumber();
        Student student = studentList.get(id);
        if(student==null){
            throw new NullPointerException();
        }
        System.out.println(student);
    }
    public static void showAll() throws IOException {
        HashMap<Integer,Student> studentList = FileHelper.readFile();
        if(studentList==null){
            throw new NullPointerException();
        }
        read(studentList.values());
    }
    public static void addToJson(Student student) throws IOException {
        HashMap<Integer,Student> studentList = FileHelper.readFile();
        studentList.put(student.id,student);
        FileHelper.writeToFile(studentList);
    }
    public static void search() {
        System.out.println("Сhoose by what parameters you want to search:");
        System.out.println("- 1 By name");
        System.out.println("- 2 By surname");
        System.out.println("- 3 By lastname");
        System.out.println("- 0 Back");
        int prt = ConsoleReader.readNumber();
        String str ;

        switch (prt){
            case 1:
                System.out.println("Enter name:");
                str = ConsoleReader.readString().toLowerCase(Locale.ROOT);
                read(FileHelper.byName.subMap(str,true,str+Character.MAX_VALUE,true).values().stream().collect(Collectors.toList()));
                break;
            case 2:
                System.out.println("Enter surname:");
                str = ConsoleReader.readString().toLowerCase(Locale.ROOT);
                read(FileHelper.bySurname.subMap(str,true,str+Character.MAX_VALUE,true).values().stream().collect(Collectors.toList()));
                break;
            case 3:
                System.out.println("Enter lastname:");
                str = ConsoleReader.readString().toLowerCase(Locale.ROOT);
                read(FileHelper.byLastName.subMap(str,true,str+Character.MAX_VALUE,true).values().stream().collect(Collectors.toList()));
                break;
            case 0:
                break;
            default:
                throw new NullPointerException();
        }
    }

    private static void read(Collection<Student> students){
        if (Helper.isEmptyCollection(students)){
            System.out.println("List is empty!");
            return;
        }
        String leftAlignFormat = "|%-17s |%-17s |%-17s |%-17s |%-35s |%-17s |%n";
        System.out.format("+------------------+------------------+------------------+------------------+------------------------------------+------------------+%n");
        System.out.format("|       ID         |       Name       |     Surname      |     Lastname     |               E-mail               |   Phone Number   |%n");
        System.out.format("+------------------+------------------+------------------+------------------+------------------------------------+------------------+%n");
        int i = 0;
        for (Student student: students) {
            System.out.format(leftAlignFormat, (i + 1) + ". "
                            +student.id,
                    student.getName(),
                    student.getSurname(),
                    student.getLastName(),
                    student.email,
                    student.phoneNumber
            );
            i++;
        }
        System.out.format("+------------------+------------------+------------------+------------------+------------------------------------+------------------+%n");
    }
}
