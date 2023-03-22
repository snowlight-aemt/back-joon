import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = input.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        int[] twoLine = new int[n + 1];
        twoLine[0] = 0;
        List<Integer> collect = Arrays.stream(input.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int idx = 1;
        for (Integer num : collect) {
            twoLine[idx++] = num;
        }

        for (int i = 1; i < n + 1; i++) {
            twoLine[i] = twoLine[i-1] + twoLine[i];
        }

        for (int j = 0; j < m; j++) {
            String[] temp = input.readLine().split(" ");
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[1]);

            System.out.println(twoLine[second] - twoLine[first - 1]);
        }
    }
}