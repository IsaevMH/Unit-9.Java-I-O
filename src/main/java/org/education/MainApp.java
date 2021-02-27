package org.education;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\iwork\\lesson8");
        if(directory.isDirectory() && directory.exists())
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
}
