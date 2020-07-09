package l152_160StreamsSerialization;

import java.io.File;
import java.io.IOException;

public class Main159File {
    public static void main(String[] args) throws IOException {
        File directorio = new File("resources");
        System.out.println(directorio.listFiles().toString());
        for(File f:directorio.listFiles()){
            System.out.println(f.getName());
        }

        File directorio2 = new File("resources\\newFolder\\newFolder");
        File newFile = new File(directorio2, "newFile.txt");
        directorio2.mkdirs();
        newFile.createNewFile();
    }
}
