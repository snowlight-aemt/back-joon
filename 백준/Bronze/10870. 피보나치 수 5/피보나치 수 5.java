import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine()) + 1;
        int[] pArr = new int[count];
        int result = 0;
        for (int i = 0; i < count; i++) {
            if (i < 2) {
                pArr[i] = i;
                continue;
            }

            result = p(pArr, i);
            pArr[i] = result;
        }
        System.out.println(pArr[count - 1]);
    }

    public static int p(int[] numbers, int index) {
        if (index < 2)
            return 1;

        return numbers[index-1] + numbers[index-2];
    }
}