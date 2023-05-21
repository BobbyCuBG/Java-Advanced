package _04_StreamsFilesDirectories.Lab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class _09_SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube("blue", 1, 5, 6);
        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Lab/CubeInfoSerialization.ser";

        try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
