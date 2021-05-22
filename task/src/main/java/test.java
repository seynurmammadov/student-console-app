import Models.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class test {
    /*
    * List<Student> studentList=  new ArrayList<>();
        studentList.add(new Student("Seynur","Mammadov","Seymur","seynursm@code.edu.az","+994559294860"));
        studentList.add(new Student("Qabil","Qurbanov","Vəli","sabil@code.edu.az","+994559294861"));
        studentList.add(new Student("Vəli","Əliyev","Nail","vali@code.edu.az","+994559294862"));
        studentList.add(new Student("Nail","İsmayılov","Vahid","nail@code.edu.az","+994559294863"));
        studentList.add(new Student("Vahid","Əliyev","Valeh","vahid@code.edu.az","+994559294864"));
        studentList.add(new Student("Valeh","Hüseynli","Kənan","valeh@code.edu.az","+994559294865"));
        studentList.add(new Student("Kənan","Qarazadə","Əli","kanan@code.edu.az","+994559294866"));
        studentList.add(new Student("Əli","Ağayev","Kamil","ali@code.edu.az","+994559294867"));
        studentList.add(new Student("Kamil","Məmmədli","Nərgiz","kamil@code.edu.az","+994559294868"));
        studentList.add(new Student("Nərgiz","Nüsrətzadə","Elvin","nargiz@code.edu.az","+994559294870"));
        studentList.add(new Student("Elvin","Sadıqov","Cavid","elvin@code.edu.az","+994559294890"));
        studentList.add(new Student("Cavid","Ələkbərli","Vahid","cavid@code.edu.az","+994559294832"));

        Type listType = new TypeToken<List<Student>>() {}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(studentList,listType);
        BufferedWriter bwjson= Files.newBufferedWriter(Path.of("students.json"));
            bwjson.write(json);
            bwjson.close();

        //*Json to object*//*
        List<Student> studentsRead = gson.fromJson(json,listType);
            studentsRead.stream().forEach(System.out::println);*/
}
