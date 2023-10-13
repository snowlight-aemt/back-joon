import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static int g_w = 0;
    static int g_b = 0;
    static int[][] g_paper = null;
    static int[][] direction = {{0,0}, {1,0}, {0,1}, {1,1}};
    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        g_paper = new int[n][n];
        // int paper[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] cell = input.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                g_paper[i][j] = Integer.parseInt(cell[j]);
            }
        }

        repeat(0, 0, n);
        System.out.println(g_w);
        System.out.println(g_b);
    }

    public static void repeat(int x, int y, int size) {
        int init = g_paper[y][x];
        boolean isFlug = true;
        for (int i = 0; i < size; i++) {;
            for (int j = 0; j < size; j++) {
                if (g_paper[i+y][j+x] != init) {
                    int nSize = size/2;
                    isFlug = false;
                    for (int k = 0; k < direction.length; k++) {
                        // Arrays.copyOfRange(g_paper[0], (k*nSize), (k*nSize)+nSize);
                        int nX = x + direction[k][0] * nSize;
                        int nY = y + direction[k][1] * nSize;
                        repeat(nX, nY, nSize);
                    }
                    
                    if (isFlug == false)
                        break;
                }
            }
            if (isFlug == false)
                break;
        }
        
        if (isFlug) {
            if (init == 0) g_w++;
            else if (init == 1) g_b++;
        }
    }
}