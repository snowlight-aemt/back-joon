import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer[] numbers = new Integer[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(input.nextLine());
        }

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        int temp = 0;
        for(int i = 0; i < numbers.length - 1; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        System.out.println(sum / numbers.length);
        System.out.println(numbers[2]);
    }
}

