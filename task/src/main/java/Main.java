import Helper.FileHelper;
import Menu.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHelper.getFiles();
        Menu.menu();
    }
}
