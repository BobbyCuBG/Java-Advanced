package _03_SetsAndMapsAdvanced.Exercise;

import java.util.HashMap;
import java.util.Map;

public class Profiler {

    private final Map<String, Long> methodExecutionTime = new HashMap<>();

    public void start() {
        // Start profiling.
    }

    public void stop() {
        // Stop profiling.
    }

    public Map<String, Long> getMethodExecutionTime() {
        return methodExecutionTime;
    }

    public static void main(String[] args) {
        Profiler profiler = new Profiler();

        // Start profiling.
        profiler.start();

        // Do some work.
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }

        // Stop profiling.
        profiler.stop();

        // Print the results.
        Map<String, Long> methodExecutionTime = profiler.getMethodExecutionTime();
        for (String method : methodExecutionTime.keySet()) {
            System.out.println(method + " took " + methodExecutionTime.get(method) + " milliseconds.");
        }
    }
}
