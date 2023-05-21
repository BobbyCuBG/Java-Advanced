package _04_StreamsFilesDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;

public class _08_NestedFolders {
    public static void main(String[] args) {
        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int count = 0;
        //Breadth-First Search (BFS)
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders%n", count);
    }
}