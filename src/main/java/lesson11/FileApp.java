package lesson11;

import java.io.File;
import java.io.IOException;

public class FileApp {
    public static void main(String[] args) throws IOException {
        File parentDir = new File("dir");
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        File file = new File(parentDir,"demo.txt"); //создается абстракция для доступа к файлу (файл здесь не создается)
        System.out.println("File exists "+ file.exists()); //проверяет существует файл или нет (по умолчанию в src ищет)

        if(!file.exists()){
            file.createNewFile();
        }

        System.out.println("IsFile " + file.isFile() + " isDirectory " + file.isDirectory());

        System.out.println(file.getParent());

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());

        for (File f : parentDir.listFiles()){
            if(f.isDirectory()){
                continue;
            }else System.out.println(f.getName());
        }

        file.length();

    }

}
