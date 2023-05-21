package _04_StreamsFilesDirectories.Lab;

import java.io.*;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/05.WriteEveryThirdLineOutput.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

        String line;
        int lineCounter = 1;
        while ((line = reader.readLine()) != null) {
            if (lineCounter % 3 == 0) {
                writer.println(line);
            }
            lineCounter++;
        }

        reader.close();
        writer.close();
    }
}
