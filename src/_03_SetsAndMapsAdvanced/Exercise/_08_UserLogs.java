package _03_SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class _08_UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> usernameAndIp = new TreeMap<>();

        String input = sc.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            usernameAndIp.putIfAbsent(username, new LinkedHashMap<>());
            usernameAndIp.get(username).putIfAbsent(ip, 0);
            usernameAndIp.get(username).put(ip, usernameAndIp.get(username).get(ip) + 1);

            System.out.println();
            input = sc.nextLine();
        }
        usernameAndIp.forEach((username, ip) -> {
            System.out.println(username + ":");
            List<String> listOfIp = new ArrayList<>();
            ip.forEach((k, v) -> {
                listOfIp.add(k + " => " + v);
            });
            System.out.print(String.join(", ", listOfIp));
            System.out.println(".");
        });
    }
}
