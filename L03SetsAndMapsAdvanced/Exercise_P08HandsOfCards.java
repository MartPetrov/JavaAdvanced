package L03SetsAndMapsAdvanced;

import java.util.*;

public class Exercise_P08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String playerName = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];

            String[] cardsArr = cards.split(", ");
            Set<String> cardsSet = new HashSet<>(Arrays.asList(cardsArr));
            if (!players.containsKey(playerName)) {
                players.put(playerName, cardsSet);
            } else {
                Set<String> currentCars = players.get(playerName);
                currentCars.addAll(cardsSet);
                players.put(playerName, currentCars);
            }

            input = scanner.nextLine();
        }

        players.entrySet().forEach(entry -> {
            Set<String> cards = entry.getValue();
            int points = getpoints(cards);
            System.out.printf("%s: %d%n", entry.getKey(), points);
        });
    }

    private static int getpoints(Set<String> playersSet) {
        Map<Character, Integer> symbolsValues = getSymbolsValues();
        int sumPoints = 0;
        for (String card : playersSet) {
            int point = 0;
            if (card.startsWith("10")) {
                char type = card.charAt(2);
                point = 10 * symbolsValues.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                point = symbolsValues.get(power) * symbolsValues.get(type);

            }
            sumPoints += point;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {

        Map<Character,Integer> characterValues = new HashMap<>();
        characterValues.put('2',2);
        characterValues.put('3',3);
        characterValues.put('4',4);
        characterValues.put('5',5);
        characterValues.put('6',6);
        characterValues.put('7',7);
        characterValues.put('8',8);
        characterValues.put('9',9);
        characterValues.put('J',11);
        characterValues.put('Q',12);
        characterValues.put('K',13);
        characterValues.put('A',14);
        characterValues.put('S',4);
        characterValues.put('H',3);
        characterValues.put('D',2);
        characterValues.put('C',1);
        return characterValues;

    }
}
