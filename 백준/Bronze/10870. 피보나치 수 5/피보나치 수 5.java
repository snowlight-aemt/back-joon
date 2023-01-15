import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine()) + 1;
        int[] pArr = new int[count];
        
        for (int i = 0; i < count; i++)
            pArr[i] = p(pArr, i);

        System.out.println(pArr[count - 1]);
    }

    public static int p(int[] numbers, int index) {
        if (index < 2)
            return index;

        return numbers[index-1] + numbers[index-2];
    }
}