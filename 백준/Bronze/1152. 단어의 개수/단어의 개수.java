import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input1 = s.nextLine();

//        String input1 = " ";
        input1 = input1.trim();
        if (input1.isBlank()) {
            System.out.println("0");;
        } else {
            System.out.println(input1.split(" ").length);
        }
    }
}
