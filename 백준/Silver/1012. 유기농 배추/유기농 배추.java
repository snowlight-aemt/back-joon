import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] g_board;
    static boolean[][] g_visited;
    static int [][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCnt = Integer.parseInt(input.readLine());
        String[][] testCaseArr = new String[testCaseCnt][];
        for (int i = 0; i < testCaseCnt; i++) {
            String bashBoardStr = input.readLine();
            String[] bashboard = bashBoardStr.split(" ");
            int colCnt = Integer.parseInt(bashboard[0]);
            int rowCnt = Integer.parseInt(bashboard[1]);
            int itemCnt = Integer.parseInt(bashboard[2]);
            
            testCaseArr[i] = new String[itemCnt + 1];
            testCaseArr[i][0] = bashBoardStr;
            for (int j = 1; j < testCaseArr[i].length; j++) {
                testCaseArr[i][j] = input.readLine();
            }
        }


        for (int i = 0; i < testCaseCnt; i++) {
            String[] bashboard = testCaseArr[i][0].split(" ");
            int colCnt = Integer.parseInt(bashboard[0]);
            int rowCnt = Integer.parseInt(bashboard[1]);
            int itemCnt = Integer.parseInt(bashboard[2]);

            g_board = new boolean[rowCnt][colCnt];
            g_visited = new boolean[rowCnt][colCnt];
            
            for (int j = 0; j <itemCnt; j++) {
                String[] pos = testCaseArr[i][j + 1].split(" ");
                int col = Integer.parseInt(pos[0]);
                int row = Integer.parseInt(pos[1]);

                g_board[row][col] = true;
            }

            int cnt = 0;
            for (int j = 0; j < rowCnt; j++) {
                for (int k = 0; k < colCnt; k++) {
                    if (!g_board[j][k] || g_visited[j][k]) {
                        continue;
                    }
                    
                    g_visited[j][k] = true;
                    cnt++;
                    DFS(k, j);
                }
            }
            System.out.println(cnt);
        }

        System.out.println();
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < direction.length; i++) {
            int[] movePos = direction[i];
            int moveX = x + movePos[0];
            int moveY = y + movePos[1];
            if (doesNotPass(moveX, moveY, g_board[0].length, g_board.length)
                || !g_board[moveY][moveX]
                || g_visited[moveY][moveX]) {
                continue;
            }

            g_visited[moveY][moveX] = true;
            DFS(moveX, moveY);
        }
        return;
    }

    public static boolean doesNotPass(int x, int y, int maxX, int maxY) {
        if (x < 0 || x >= maxX
                || y < 0 || y >= maxY) {           
            return true;
        }

        return false;
    }
}