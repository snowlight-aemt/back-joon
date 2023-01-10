import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String str = input.readLine();
        System.out.println(repeat(Integer.parseInt(str)));
    }

    public static int repeat(int number) {
        if (number == 0) return 1;
        return number * repeat(--number);
    }
}