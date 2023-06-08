package _04_StreamsFilesDirectories.Exercise;

import java.io.Serializable;

public class Course implements Serializable {
    String names;
    int studentCount;

    public Course(String names, int studentCount) {
        this.names = names;
        this.studentCount = studentCount;
    }
}
