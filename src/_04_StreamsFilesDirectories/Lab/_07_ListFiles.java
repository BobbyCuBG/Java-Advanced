package _04_StreamsFilesDirectories.Lab;

import java.io.File;

public class _07_ListFiles {
    public static void main(String[] args) {
        String folderPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName() + ": [" + file.length() + "]");
                    }
                }
            }
        }
    }
}
