package _04_StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
public class _06_WordCount {
    public static void main(String[] args) {
        String wordsPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String textPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        String resultPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/06result.txt";


        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader wordReader = Files.newBufferedReader(Paths.get(wordsPath));
        BufferedReader textReader = Files.newBufferedReader(Paths.get(textPath));
             PrintWriter writer = new PrintWriter(resultPath)) {
            String wordLine = wordReader.readLine();

            while (wordLine != null) {
                String[] words = wordLine.split("\\s+");

                for (String word : words) {
                    wordCount.put(word, 0);
                }
                wordLine = wordReader.readLine();
            }

            String textLine = textReader.readLine();

            while (textLine != null) {
                String[] textLines = textLine.split("\\s+");

                for (String line : textLines) {
                    if (wordCount.containsKey(line)) {
                        wordCount.put(line, wordCount.get(line) + 1);
                    }
                }
                textLine = textReader.readLine();
            }


            wordCount.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e -> writer.write(String.format("%s - %d%n", e.getKey(), e.getValue())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
