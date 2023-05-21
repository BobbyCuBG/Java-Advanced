package _04_StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _02_WriteToFile {
    public static void main(String[] args) throws IOException {
        List<Character> punctuation = new ArrayList<>();
        punctuation.add('.');
        punctuation.add(',');
        punctuation.add('!');
        punctuation.add('?');

        String inputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int bytInt = inputStream.read();
        while (bytInt >= 0) {
            char currChar = (char) bytInt;
            if (!punctuation.contains(currChar)) {
                outputStream.write(currChar);
            }
            bytInt = inputStream.read();
        }
        inputStream.close();
    }
}
