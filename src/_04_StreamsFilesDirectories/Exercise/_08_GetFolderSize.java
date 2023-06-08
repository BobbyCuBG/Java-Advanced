package _04_StreamsFilesDirectories.Exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _08_GetFolderSize {
    public static void main(String[] args) throws IOException {
        String folderPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";

        int folderSize = 0;
        Path path = Paths.get(folderPath);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                File[] files = new File(folderPath).listFiles();

                if (files != null) {
                    for (File file : files) {
                        folderSize += file.length();
                    }
                }
            }
        }
        System.out.printf("Folder size: %d%n", folderSize);
    }
}
