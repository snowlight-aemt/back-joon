import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String resolve = input.readLine();
//        StringBuilder sb = new StringBuilder();
//
//        int count = Integer.parseInt(input.readLine());
//        String resolve = "999998999";
        int length = resolve.length();

        int counter[] = new int [10];

        for (int i = 0; i < length; i++) {
            counter[Character.getNumericValue(resolve.charAt(i))] += 1;
        }

        for (int i = counter.length - 1; i >= 0; i--) {
            int idx = counter[i];
            for (int j = 0; j < idx; j++) {
                System.out.print(i);
            }
        }
    }
}

