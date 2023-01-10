import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String str = input.readLine();
        Long output = 1L;

        for (long i = 1; i <= Long.parseLong(str); i++)
            output *= i;

        System.out.println(output);
    }
}