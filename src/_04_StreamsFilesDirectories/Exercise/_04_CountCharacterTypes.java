package _04_StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {
        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/04output.txt";

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> punctuation = List.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int othersCount = 0;
        int punctuationCount = 0;

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path));
             PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(Path.of(outputPath)))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuation.contains(c)) {
                        punctuationCount++;
                    } else if (c != ' ') {
                        othersCount++;
                    }
                }
                line = bufferedReader.readLine();
            }
            printWriter.write(String.format("""
                    Vowels: %d
                    Other symbols: %d
                    Punctuation: %d""", vowelsCount, othersCount, punctuationCount));


        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}