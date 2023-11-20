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
        int N = Integer.parseInt(str[0]); // 나무 수
        int M = Integer.parseInt(str[1]); // 필요한 길이

        long max = 0;
        long min = 0;

        int[] trees = new int[N];
        String[] treesStre = in.readLine().split(" ");
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(treesStre[i]);
            if (max < trees[i]) {
                max = trees[i];
            }
        }
        long mid = 0;
        long sum = 0;
        while (min < max) {
            sum = 0;
            mid = (min + max) / 2;
            

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] - mid  <= 0) {
                    continue;
                }

                sum += (trees[i] - mid);
            }

			if(sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
            // if (M < sum) {
            //     min = mid + 1;
            // } else {
            //     max = mid;
            // }
        }

        System.out.println(max - 1);
    }
}