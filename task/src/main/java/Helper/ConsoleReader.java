package Helper;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class ConsoleReader {

    public static void checkString(String val){
        if(val.length()==0){
            throw new NullPointerException();
        }
    }
    public static String readString(){
        Scanner scanner = Helper.generateScanner();
        String val = scanner.nextLine().trim();
        checkString(val);
        return val;
    }
    public static String readEmail(){
        String val= readString();
        if (val.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return val;
        }
        throw new NullPointerException();
    }
    public static boolean isPositive(int num){
        return num >= 0;
    }
    public static int readNumber() {
        Scanner scanner = Helper.generateScanner();
        int num= scanner.nextInt();
        if(!isPositive(num)) throw new NullPointerException();
        return num;
    }

}
