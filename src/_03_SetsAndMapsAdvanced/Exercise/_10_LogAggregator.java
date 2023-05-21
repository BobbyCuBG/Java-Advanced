package _03_SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class _10_LogAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> userAndIP = new TreeMap<>();
        Map<String, Integer> userLogs = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String ip = input[0];
            String username = input[1];
            int numberOfLogs = Integer.parseInt(input[2]);

            userAndIP.putIfAbsent(username, new ArrayList<>());
            if (!userAndIP.get(username).contains(ip)) {
                userAndIP.get(username).add(ip);
            }

            userLogs.putIfAbsent(username, 0);
            userLogs.put(username, userLogs.get(username) + numberOfLogs);
        }

        userAndIP.forEach((username, ipLogs) -> {
            ipLogs.sort(Comparator.naturalOrder());
            System.out.printf("%s: %d %s%n", username, userLogs.get(username), ipLogs);
        });
    }
}
