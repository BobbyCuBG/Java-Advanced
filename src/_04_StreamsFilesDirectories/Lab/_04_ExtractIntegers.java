package _04_StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream("/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt"));

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                out.println(sc.nextInt());
            }
            sc.next();
        }
    }
}
