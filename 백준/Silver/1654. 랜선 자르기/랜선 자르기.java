import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader in = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        String[] str = in.readLine().split(" ");
        int K = Integer.parseInt(str[0]); // 가지고 있는 랜선 수
        int N = Integer.parseInt(str[1]); // 필요한 랜선 수

        int[] arr = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max += 1;

        long mid = 0;
        long min = 0;

        while (min < max) {
            mid = (max + min) / 2;

            long lenCount = 0;
            for (int i = 0; i < arr.length; i++) {
                lenCount += (arr[i] / mid);
            }
            
            if (lenCount < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        System.out.println(min - 1);
    }
}