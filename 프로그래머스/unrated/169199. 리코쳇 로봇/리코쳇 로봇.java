import java.util.Arrays;

class Solution {
    // 우, 좌, 하, 상
    int[][] g_directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int g_xSize = 0;
    int g_ySize = 0;
    String[][] g_boards;
    int[] g_goal = new int[2];
    int g_start[] = new int[2];
    int g_answer = Integer.MAX_VALUE;
    int g_visite[][];

    public int solution(String[] board) {
        g_boards = new String[board.length][];
        g_ySize = board.length;
        g_xSize = board[0].length();

        g_visite = new int[g_ySize][g_xSize];
        for (int[] ints : g_visite ) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = 0; i < board.length; i++) {
            String[] x_pos = new String[g_xSize];
            for (int j = 0; j < g_xSize; j++) {
                x_pos[j] = String.valueOf(board[i].charAt(j));

                if (x_pos[j].equals("R")) {
                    g_start[0] = j;
                    g_start[1] = i;
                } 
                if (x_pos[j].equals("G")) {
                    g_goal[0] = j;
                    g_goal[1] = i;
                }
            }
            
            g_boards[i] = x_pos;
        }

        System.out.println("");

        int col = g_start[0];
        int row = g_start[1];
        bfs(col, row, 0);

        return g_answer == Integer.MAX_VALUE ? -1 : g_answer;
    }

    private void bfs(int col, int row, int cnt) {
        if (g_goal[0] == col && g_goal[1] == row) {
            g_answer = Math.min(g_answer, cnt);
            return;
        }

        for (int i = 0; i < g_directions.length; i++) {

            int[] block = go(col, row, g_directions[i]);


            if (g_visite[block[1]][block[0]] <= cnt + 1) {
                continue;
            }

            g_visite[block[1]][block[0]] = cnt + 1;

            bfs(block[0], block[1], cnt + 1);
        }
    }

    private int[] go(int col, int row, int[] directions) {
        while(true) {
            int nextCol = col + directions[0];
            int nextRow = row + directions[1];
            if (isBlock(nextCol, nextRow)) {
                return new int[] {col, row};
            }

            col += directions[0];
            row += directions[1];
        }
    }

    private boolean isBlock(int col, int row) {
        int[] rPoint = new int[] {col, row};
        if (
            rPoint[1] < 0 || rPoint[1] >= g_ySize
            || (rPoint[0] < 0 || rPoint[0] >= g_xSize)
            || g_boards[rPoint[1]][rPoint[0]].equals("D")
        ) {
            return true;
        }

        return false;
    }
}