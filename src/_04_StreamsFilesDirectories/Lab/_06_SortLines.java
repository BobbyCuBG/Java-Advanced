package _04_StreamsFilesDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        List<String> lines = Files.readAllLines(path);

        Collections.sort(lines);
        Path outputPath = Paths.get("/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/06.SortLinesOutput.txt");
        Files.write(outputPath, lines);

    }
}
