import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String inputValue = input.readLine();
        int n = Integer.parseInt(inputValue.split(" ")[0]);
        int m = Integer.parseInt(inputValue.split(" ")[1]);

        Map<String, String> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String result = input.readLine();
            map.put(result, result);
        }
        for (int i = n; i < n + m; i++) {
            if (map.containsKey(input.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}