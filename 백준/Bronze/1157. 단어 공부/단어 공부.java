import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input1 = s.nextLine();
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : input1.toCharArray()) {
            Integer count = map.getOrDefault(Character.toUpperCase(c), 0);
            map.put(Character.toUpperCase(c), ++count);
        }

        Character result = null;
        Integer maxCount = 0;
        Integer prevMaxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (v >= maxCount) {
                prevMaxCount = maxCount;
                maxCount = v;
                result = k;
            }
        }

        if (prevMaxCount.equals(maxCount)) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}