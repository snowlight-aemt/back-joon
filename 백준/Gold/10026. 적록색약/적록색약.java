import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int direction[][] = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
    static boolean[][] g_visited;
    static boolean[][] g_r_visited;
    static String[][] g_board;

    static int g_size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        g_size = Integer.valueOf(input.readLine());
        
        String[] str = new String[g_size];
        for (int i = 0; i < g_size; i++) {
            str[i] = input.readLine();
        }

        g_board = new String[g_size][g_size];

        for (int i = 0; i < g_size; i++) {
            for (int j = 0; j < g_size; j++) {
                g_board[i][j] = Character.toString(str[i].charAt(j));
            }
        }

        g_visited = new boolean[g_size][g_size];

        int answer = 0;
        for (int i = 0; i < g_size; i++) {
            for (int j = 0; j < g_size; j++) {
                
                if (g_visited[i][j]) {
                    continue;
                }

                g_visited[i][j] = true;
                String color = g_board[i][j];

                DFS(j, i, color);

                answer++;
            }
        }
        System.out.print(answer + " ");

        
        
        g_r_visited = new boolean[g_size][g_size];

        answer = 0;
        for (int i = 0; i < g_size; i++) {
            for (int j = 0; j < g_size; j++) {
                
                if (g_r_visited[i][j]) {
                    continue;
                }

                g_r_visited[i][j] = true;
                String color = g_board[i][j];
                DFS_G(j, i, color);

                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int x, int y, String color) {

        for (int i = 0; i < 4; i++) {
            int moveX = x + direction[i][0];
            int moveY = y + direction[i][1];

            if (overBoard(moveX, moveY)) {
                continue;
            }

            if (g_visited[moveY][moveX]) {
                continue;
            }

            if (!g_board[moveY][moveX].equals(color)) {
                continue;
            }

            g_visited[moveY][moveX] = true;
            DFS(moveX, moveY, g_board[moveY][moveX]);
        }

    }

    private static boolean overBoard(int moveX, int moveY) {
        return moveX < 0 || moveX >= g_size
            || moveY < 0 || moveY >= g_size;
    }

    private static void DFS_G(int x, int y, String color) {

        for (int i = 0; i < 4; i++) {
            int moveX = x + direction[i][0];
            int moveY = y + direction[i][1];

            if (overBoard(moveX, moveY)) {
                continue;
            }

            if (g_r_visited[moveY][moveX]) {
                continue;
            }

            if ((color.equals("R") && g_board[moveY][moveX].equals("G")) 
                || (color.equals("G") && g_board[moveY][moveX].equals("R")) 
                    || g_board[moveY][moveX].equals(color)) {
                g_r_visited[moveY][moveX] = true;
                DFS_G(moveX, moveY, color);
            }

            continue;
        }

    }
}