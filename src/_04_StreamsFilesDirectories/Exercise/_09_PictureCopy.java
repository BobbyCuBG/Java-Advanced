package _04_StreamsFilesDirectories.Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_PictureCopy {
    public static void main(String[] args) throws IOException {
        String picturePath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/picture.jpg";
        String copyPath = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/picture-copy.jpg";

        FileInputStream inputStream = new FileInputStream(picturePath);
        FileOutputStream outputStream = new FileOutputStream(copyPath);

        int byteRead = inputStream.read();
        while (byteRead != -1) {
            outputStream.write(byteRead);
            byteRead = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
