package Helper;

import Models.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileHelper {
    static Type hashType = new TypeToken<HashMap<Integer,Student>>() {}.getType();
    public static NavigableMap<String,Student> byName= new TreeMap<>();
    public static NavigableMap<String,Student> bySurname= new TreeMap<>();
    public static NavigableMap<String,Student> byLastName= new TreeMap<>();

    public static HashMap<Integer,Student> readFile() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        var studentsRead = gson.fromJson(Files.newBufferedReader(Path.of("students.json")),hashType);
        if(studentsRead==null){
            studentsRead= new HashMap();
        }
        return (HashMap<Integer, Student>) studentsRead;
    }
    public static void writeToFile(HashMap<Integer,Student> studentList) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(studentList,hashType);
        BufferedWriter bwjson= Files.newBufferedWriter(Path.of("students.json"));
        bwjson.write(json);
        bwjson.close();
        getFiles();
    }
    public static void getFiles() throws IOException {
        var studentList = FileHelper.readFile();
        studentList.values().forEach(s->{
            byName.put(s.getName().toLowerCase(Locale.ROOT)+s.getId(),s);
            bySurname.put(s.getSurname().toLowerCase(Locale.ROOT)+s.getId(),s);
            byLastName.put(s.getLastName().toLowerCase(Locale.ROOT)+s.getId(),s);
        });
    }
}
