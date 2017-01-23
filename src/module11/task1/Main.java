package module11.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by g.zubenko on 23.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        //Finding file path for running project from IDE
        String currentDir = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String filePath = currentDir.substring(0,currentDir.lastIndexOf("out/production"))
                +"src/module11/task1/"+"textFile.txt";

        //Reading a string from file
        File file = new File(filePath);
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        }
        catch (FileNotFoundException e){
            System.out.println("file '"+file.getAbsolutePath()+"' not found");
            return;
        }
        String str;
        try (BufferedReader reader = new BufferedReader(fileReader)){
            str = reader.readLine();
        }
        catch (IOException e){
            System.out.println("Reading file '"+file.getAbsolutePath()+"' was failed");
            return;
        }

        //creating parameters for reverseSting
        Map<String, String> map = new HashMap<>();
        String oldStr = "text";
        String newStr = "'changed string'";
        map.put(oldStr, newStr);

        //reversing string
        System.out.println("Initial string from file '"+file.getAbsolutePath()+"': '"+str+"'");
        System.out.println("Try to replace string '"+oldStr+"' to '"+newStr+"'");
        String reversedString = reverseSting(map, str);
        System.out.println("New string: "+reversedString);
        System.out.println();

        //Task2 writing to a new file
        String newFilePath = currentDir.substring(0,currentDir.lastIndexOf("out/production"))
                +"src/module11/task1/"+"newTextFile.txt";
        File newFile = new File(newFilePath);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(newFile);
            try (BufferedWriter writer = new BufferedWriter(fileWriter)){
                writer.write(reversedString);
            }
            catch (IOException e){
                System.out.println("IOException occur while writing file '"+newFile.getAbsolutePath()+"'");
            }
            System.out.println("File '"+newFile.getAbsolutePath()+"' was overridden");
        }
        catch (IOException e){
            System.out.println("IOException occur while opening file '"+newFile.getAbsolutePath()+"'");
        }

        //Task3 writing to an existing file
        String existingFilePath = currentDir.substring(0,currentDir.lastIndexOf("out/production"))
                +"src/module11/task1/"+"existingTextFile.txt";
        File existingFile = new File(existingFilePath);
        try {
            fileWriter = new FileWriter(existingFile, true);
            try (BufferedWriter writer = new BufferedWriter(fileWriter)){
                writer.write(reversedString+"\n");
            }
            catch (IOException e){
                System.out.println("IOException occur while writing file '"+existingFile.getAbsolutePath()+"'");
            }
            System.out.println("Reversed string was written to file '"+existingFile.getAbsolutePath()+"'");
        }
        catch (IOException e){
            System.out.println("IOException occur while opening file '"+existingFile.getAbsolutePath()+"'");
        }
    }

    private static String reverseSting(Map<String, String> map, String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        map.forEach((key, val)->strBuilder.replace(0,strBuilder.length(),strBuilder.toString().replaceAll(key,val)));
        return strBuilder.toString();
    }
}
