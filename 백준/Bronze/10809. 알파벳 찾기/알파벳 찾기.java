import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine().toLowerCase();

        Character[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Map<Character, Integer> map = new HashMap<>();
        for (Character s : alpha) {
            map.put(s, -1);
        }

        for (int i = 0; i < input1.length(); i++) {
            Character c = input1.toCharArray()[i];
            Integer checkNumber = map.get(c);
            if (checkNumber != -1)
                continue;

            map.put(c, i);
        }

        map.forEach((c, i) -> {
            System.out.print(i + " ");
        });
    }
}