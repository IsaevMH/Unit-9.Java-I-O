package org.education;

import java.io.*;
import java.util.Objects;

public class MainApp {

    public static void writeDirectoryStructureInFile(File directory){
        {
            try(FileWriter fileWriter = new FileWriter("data/directoryInfo.txt")) {
                for (File file : Objects.requireNonNull(directory.listFiles())) {
                    fileWriter.write("|-----" + file.getName() + "\n");
                    for (File listFile : Objects.requireNonNull(file.listFiles())) {
                        fileWriter.write("|     " + listFile.getName() + "\n");
                    }
                    fileWriter.write("|\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printInfromationAboutDirectory(File file){
        int countOfFiles = 0;
        int countOfDirectory = 0;
        int lengthName = 0;
        try(FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            System.out.println(bufferedReader.readLine());
            for (File lFile : file.getParentFile().listFiles()) {
                if (lFile.isFile() && lFile.exists()){
                    countOfFiles++;
                    lengthName += lFile.getName().length();
                }
                else if(lFile.isDirectory() && lFile.exists())
                    countOfDirectory++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Колиество файлов: " + countOfFiles
                + "\nКоличество папок: " + countOfDirectory
                + "\nСредняя длина названия файла: " + lengthName / countOfFiles);
    }
    public static void main(String[] args) {
        String path = "C:\\\\Users\\\\iwork\\\\lesson8\\";
        path = "C:\\\\Users\\\\iwork\\\\lesson8\\firstFolder\\someDocumentsWithChars.txt";
        File file = new File(path);
        if(file.isDirectory() && file.exists()){
            writeDirectoryStructureInFile(file);
        }
        else if(file.isFile() && file.exists()){
            printInfromationAboutDirectory(file);
        }
        else
            System.out.println("Файла/директории не существует");
    }
}
