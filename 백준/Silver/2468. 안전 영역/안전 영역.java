import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAX_NUM = 100;
    private static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int g_nSize;
    private static int[][] g_boards;

    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        g_nSize = Integer.parseInt(input.readLine());
        g_boards = new int[g_nSize][g_nSize];
        for (int i = 0; i < g_nSize; i++) {
            String[] line = input.readLine().split(" ");
            for (int j = 0; j < g_nSize; j++) {
                g_boards[i][j] = Integer.parseInt(line[j]);
            }
        }

        int maxCnt = Integer.MIN_VALUE;
        for (int limitNum = 1; limitNum <= MAX_NUM; limitNum++) {
            boolean[][] visite = new boolean[g_nSize][g_nSize];
            int cnt = 0;

            for (int i = 0; i < g_nSize; i++) {
                for (int j = 0; j < g_nSize; j++) {

                    if (g_boards[i][j] < limitNum) {
                        continue;
                    }

                    if (visite[i][j]) {
                        continue;
                    }

                    visite[i][j] = true;
                    DFS(j, i, limitNum, visite);
                    cnt++;
                }
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }

        System.out.println(maxCnt);
    }

    private static void DFS(int x, int y, int limitNum, boolean[][] visite) {
        for (int i = 0; i < direction.length; i++) {
            int xMove = x + direction[i][0];
            int yMove = y + direction[i][1];

            if (xMove < 0 || xMove >= g_nSize ||
                yMove < 0 || yMove >= g_nSize) {
                continue;
            }

            if (g_boards[yMove][xMove] < limitNum) {
                continue;
            }

            if (visite[yMove][xMove]) {
                continue;
            }

            visite[yMove][xMove] = true;
            DFS(xMove, yMove, limitNum, visite);
        }
    }
}