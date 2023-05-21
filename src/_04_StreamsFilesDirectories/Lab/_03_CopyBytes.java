package _04_StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String inputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int byteInt = inputStream.read();
        while (byteInt >= 0) {
            String digits = String.valueOf(byteInt);

            if (digits.equals("32")) {
                outputStream.write(' ');
            } else if (digits.equals("10")) {
                outputStream.write(10);
            } else {
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
            byteInt = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
