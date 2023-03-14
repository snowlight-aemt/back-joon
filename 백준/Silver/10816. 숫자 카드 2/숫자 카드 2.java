import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        String[] nNums = input.readLine().split(" ");
        List<Integer> nArr = Arrays.stream(nNums)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int m = Integer.parseInt(input.readLine());
        String[] mArr = input.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String str : mArr) {
            map.put(str, 0);
        }

        for (String key : nNums) {
            Integer value = map.get(key);
            if (value != null) {
                map.put(key, ++value);
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(mArr).forEach(x -> {
            sb.append(map.get(x)).append(' ');
        });
        System.out.println(sb);
    }
}