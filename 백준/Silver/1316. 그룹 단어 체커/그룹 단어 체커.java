import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int count = 0;
        for (int i = 0; i < Integer.parseInt(input); i++) {
            count = getCount(scanner.next(), count);
        }

        System.out.println(count);
    }

    private static int getCount(String input, int count) {

        Character selectedChar = null;
        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (selectedChar == null || input.charAt(i) == selectedChar) {
                selectedChar = input.charAt(i);
            } else if (map.getOrDefault(input.charAt(i), false)) {
                break;
            } else {
                map.put(selectedChar, true);
                selectedChar = input.charAt(i);
            }

            if (i == input.length() - 1) count++;
        }
        return count;
    }
}
