package _03_SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class _07_HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> playersAndCards = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");

            String player = tokens[0];
            String[] cards = tokens[1].split(", ");

            playersAndCards.putIfAbsent(player, new HashSet<>());
            for (String card : cards) {
                playersAndCards.get(player).add(card);
            }
            input = sc.nextLine();
        }

        playersAndCards.forEach((player, cards) -> {
            System.out.print(player + ": ");
            int power = 0;
            int cardType = 0;
            int cardColorValue = 0;
            for (String card : cards) {
                for (int i = 0; i < card.length(); i++) {
                    char c = card.charAt(i);
                    if (i == 0) {
                        if (Character.isDigit(c) && card.length() < 3) {
                            cardType = Integer.parseInt(String.valueOf(c));
                        } else if (card.length() == 3) {
                            cardType = Integer.parseInt(String.valueOf(10));
                            i++;
                        } else {
                            switch (c) {
                                case 'J':
                                    cardType = Integer.parseInt(String.valueOf(11));
                                    break;
                                case 'Q':
                                    cardType = Integer.parseInt(String.valueOf(12));
                                    break;
                                case 'K':
                                    cardType = Integer.parseInt(String.valueOf(13));
                                    break;
                                case 'A':
                                    cardType = Integer.parseInt(String.valueOf(14));
                                    break;
                            }
                        }
                    } else {
                        switch (c) {
                            case 'S':
                                cardColorValue = Integer.parseInt(String.valueOf(4));
                                break;
                            case 'H':
                                cardColorValue = Integer.parseInt(String.valueOf(3));
                                break;
                            case 'D':
                                cardColorValue = Integer.parseInt(String.valueOf(2));
                                break;
                            case 'C':
                                cardColorValue = Integer.parseInt(String.valueOf(1));
                                break;
                        }
                    }
                }
                power += cardType * cardColorValue;
            }
            System.out.println(power);
        });
    }
}
