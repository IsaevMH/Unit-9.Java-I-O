package org.education;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainApp {
    public static void writeDirectoryStructureInFile(File directory){
        {
            try(FileWriter fileWriter = new FileWriter("data/directoryInfo.txt")) {
                for (File file : directory.listFiles()) {
                    fileWriter.write("|-----" + file.getName() + "\n");
                    for (File listFile : file.listFiles()) {
                        fileWriter.write("|     " + listFile.getName() + "\n");
                    }
                    fileWriter.write("|\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String path = "C:\\\\Users\\\\iwork\\\\lesson8\\";
        if(path != null){
            File file = new File(path);
            if(file.isDirectory() && file.exists()){
                writeDirectoryStructureInFile(file);
            }
            else if(file.isFile() && file.exists()){

            }
            else
                System.out.println("Файла/директории не существует");
        }
    }
}
