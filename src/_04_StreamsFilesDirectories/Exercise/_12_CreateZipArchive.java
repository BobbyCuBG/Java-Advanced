package _04_StreamsFilesDirectories.Exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12_CreateZipArchive {
    public static void main(String[] args) {
        String[] fileNames = {"/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt",
                "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt",
                "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"};
        String zipFileName = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/files.zip";

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            byte[] buffer = new byte[1024];

            for (String fileName : fileNames) {
                File file = new File(fileName);

                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    zipOut.putNextEntry(new ZipEntry(file.getName()));

                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zipOut.write(buffer, 0, length);
                    }

                    fis.close();
                } else {
                    System.out.println("File not found: " + fileName);
                }
            }

            System.out.println("Zip archive created: " + zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
