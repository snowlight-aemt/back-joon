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
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int[] nDex = new int[n];
        String[] nDexStr = input.readLine().split(" ");
        for (int i = 0; i < nDexStr.length; i++) {
            nDex[i] = Integer.parseInt(nDexStr[i]);
        }

        int m = Integer.parseInt(input.readLine());
        int[] mDex = new int[m];
        String[] mDexStr = input.readLine().split(" ");
        for (int i = 0; i < mDexStr.length; i++) {
            mDex[i] = Integer.parseInt(mDexStr[i]);
        }


        Arrays.sort(nDex);
        StringBuilder sb = new StringBuilder();
        for (int card : mDex) {
            int a = lowerBound(card, nDex);
            int b = upperBound(card, nDex);
    
            sb.append(b - a).append(' ');
        }
        System.out.println(sb);
    }

    public static int lowerBound(int key, int[] dex) {
        int lo = 0;
        int hi = dex.length;

        while (true) {
            int idx = (lo + hi) / 2;
            int mid = dex[idx];
            if (key > mid)  {
                lo = idx + 1;
            } else {
                hi = idx;
            }

            if (lo >= hi) 
                break;
        }

        return lo;
    }

    public static int upperBound(int key, int[] dex) {
        int lo = 0;
        int hi = dex.length;

        while (true) {
            int idx = (lo + hi) / 2;
            int mid = dex[idx];
            if (key >= mid)  {
                lo = idx + 1;
            } else {
                hi = idx;
            }

            if (lo >= hi) 
                break;
        }
        return lo;
    }
}