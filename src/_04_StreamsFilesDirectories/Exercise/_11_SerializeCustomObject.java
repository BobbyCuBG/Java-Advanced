package _04_StreamsFilesDirectories.Exercise;

import java.io.*;

public class _11_SerializeCustomObject {
    public static void main(String[] args) {
        Course course = new Course("JAVA-Advanced", 500);

        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/course.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            oos.writeObject(course);

            Course extratedCourse = (Course) ois.readObject();
            System.out.println(extratedCourse.names + " " + extratedCourse.studentCount);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
