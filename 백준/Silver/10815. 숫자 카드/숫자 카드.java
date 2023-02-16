import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        String[] arrStr = input.readLine().split(" ");

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(arrStr[i]);

        int resultCount = Integer.parseInt(input.readLine());
        int resultArr[] = new int[resultCount];
        String resultArrStr[] = input.readLine().split(" ");

        for (int i = 0; i < resultCount; i++)
            resultArr[i] = Integer.parseInt(resultArrStr[i]);

        int tempR[] = new int[20000001];

        for (int i = 0; i < n; i++) {
            int key = getIndexPos(arr[i]);
            tempR[key] = 1;
        }

        for (int i = 0; i < resultCount; i++) {
            int key = getIndexPos(resultArr[i]);
            System.out.print(tempR[key] + " ");
        }
    }

    public static int getIndexPos(int x) {
        return x + 10000000;
    }
}