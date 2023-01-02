import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer numberCount = Integer.parseInt(input.nextLine());
        String numbers = input.nextLine();

        int total = 0;

        for (int i = 0; i < numberCount; i++)
            total += Character.digit(numbers.charAt(i), 10);

        System.out.println(total);
    }
}
