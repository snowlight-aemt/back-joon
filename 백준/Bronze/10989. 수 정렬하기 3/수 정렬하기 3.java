import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] numbers  = new int[count];
        int[] countering = new int[10001];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            countering[numbers[i]]++;
        }

        for (int i = 1; i < countering.length; i++) {
            while (countering[i] > 0) {
                sb.append(i).append('\n');
                countering[i]--;
            }

        }
        System.out.println(sb);
    }
}