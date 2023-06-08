package _04_StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _05_LineNumbers {
    public static void main(String[] args) {
        String inputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/05output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(outputPath)))) {

            String line = reader.readLine();

            int counter = 1;
            while (line != null) {
                writer.write(String.format("%d. %s%n", counter, line));

                counter++;
                line = reader.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
