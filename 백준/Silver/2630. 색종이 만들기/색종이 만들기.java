import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        if (check(x, y, size))
            return;

        int nSize = size/2;
        repeat(x, y, nSize);
        repeat(x+nSize, y, nSize);
        repeat(x, y+nSize, nSize);
        repeat(x+nSize, y+nSize, nSize);
    }

    public static boolean check(int x, int y, int size) {
        int color = g_paper[y][x];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (g_paper[i+y][j+x] != color) {
                    return false;
                }
            }
        }

        if (color == 0) g_w++;
        else if (color == 1) g_b++;

        return true;
    }
}
