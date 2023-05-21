package _04_StreamsFilesDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _08_NestedFolders {
    public static void main(String[] args) {
        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
        File root = new File(path);
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            if (nestedFiles != null) {
                for (File nestedFile : nestedFiles)
                    if (nestedFile.isDirectory())
                        dirs.offer(nestedFile);
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
