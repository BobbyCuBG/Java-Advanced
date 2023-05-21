package _04_StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int byteInt = inputStream.read();
        while (byteInt >= 0) {
            System.out.print(Integer.toBinaryString(byteInt) + " ");
            byteInt = inputStream.read();
        }
        inputStream.close();
    }
}
