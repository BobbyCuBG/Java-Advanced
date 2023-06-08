package _04_StreamsFilesDirectories.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_SerializeArrayList {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.2, 3.4, 533.4, 53.2, 3.14, 4.12);

        String path = "/Users/cubg/IdeaProjects/JavaAdvanced2023/src/_04_StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/list.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            List<?> loadedData = (List<?>) ois.readObject();
            List<Double> loadedNumbers = new ArrayList<>();
            for (Object obj : loadedData) {
                if (obj instanceof Double) {
                    loadedNumbers.add((Double) obj);
                }
            }
            loadedNumbers.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
