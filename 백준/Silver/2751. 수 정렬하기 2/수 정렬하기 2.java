import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int count = input.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(input.nextInt());
        }

        Collections.sort(numbers);

        for (int value : numbers) {
            sb.append(value).append('\n');
        }

        System.out.println(sb);
    }
}

