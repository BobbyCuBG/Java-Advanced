package _04_StreamsFilesDirectories.Lab;

import java.io.Serializable;

public class Cube implements Serializable {
    String color;
    int width;
    int length;
    int height;

    public Cube(String color, int width, int length, int height) {
        this.color = color;
        this.width = width;
        this.length = length;
        this.height = height;
    }
}
