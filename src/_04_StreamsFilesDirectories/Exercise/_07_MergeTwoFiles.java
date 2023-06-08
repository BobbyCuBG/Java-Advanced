package _04_StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _07_MergeTwoFiles {
    public static void main(String[] args) {
        String inputOne = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String inputTwo = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String output = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/07output.txt";

        try (BufferedReader readerOne = Files.newBufferedReader(Path.of(inputOne));
             BufferedReader readerTwo = Files.newBufferedReader(Path.of(inputTwo));
             PrintWriter writer = new PrintWriter(output)) {

            String lineOne = readerOne.readLine();

            while (lineOne != null) {
                writer.write(lineOne);
                writer.write(System.lineSeparator());

                lineOne = readerOne.readLine();
            }

            String lineTwo = readerTwo.readLine();

            while (lineTwo != null) {
                writer.write(lineTwo);
                writer.write(System.lineSeparator());

                lineTwo = readerTwo.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
