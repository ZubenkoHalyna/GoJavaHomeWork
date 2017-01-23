package module11.task4;

import java.io.*;

/**
 * Created by g.zubenko on 23.01.2017.
 */
public class MainWithResources {
    public static void main(String[] args) {
//Finding file path for running project from IDE
        String currentDir = module11.task1.Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
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
        String param="text";
        System.out.println("String '"+str+"' contains "+checkWord(param,str)+" word '"+param+"'");
        param="string";
        System.out.println("String '"+str+"' contains "+checkWord(param,str)+" word '"+param+"'");
        param="changed";
        System.out.println("String '"+str+"' contains "+checkWord(param,str)+" word '"+param+"'");
    }

    static int checkWord(String word, String str){
        int count=0;
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.lastIndexOf(word)!=-1){
            int position = stringBuilder.lastIndexOf(word);
            stringBuilder.delete(position, position+word.length());
            count++;
        }
        return count;
    }
}
