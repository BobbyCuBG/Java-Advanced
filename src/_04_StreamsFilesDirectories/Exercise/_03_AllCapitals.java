package _04_StreamsFilesDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            System.out.println(line.toUpperCase());
        }
    }
}
