import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String[]> g_board = new ArrayList<>();
    static int g_size;
    static int[][] g_dir = { {0, 1},{-1, 1},{-1, 0},{-1, -1},
                                    {0, -1},{1, -1},{1, 0},{1, 1} };
    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        g_size = 0;
        while (true) {
            String str = input.readLine();
            if (str.equals("0 0")) break;

            String[] strArr = str.split(" ");
            int x = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);

            g_board.add(new String[y]);
            for (int i = 0; i < y; i++) {
                g_board.get(g_size)[i] = input.readLine();
            }
            g_size++;
        }
        
        for (String[] testCase : g_board) {

            int rowSize = testCase[0].split(" ").length;
            String[][] board = new String[testCase.length][rowSize];
            boolean[][] visited = new boolean[testCase.length][rowSize];
            for (int i = 0; i < testCase.length; i++) {
                String[] xRows = testCase[i].split(" ");
                for (int j = 0; j < rowSize; j++) {
                    board[i][j] = xRows[j];
                }
            }

            int answer = 0;
            for (int i = 0; i < testCase.length; i++) {
                for (int j = 0; j < rowSize; j++) {
                    
                    if (visited[i][j]) 
                        continue;

                    if (board[i][j].equals("0"))
                        continue;

                    visited[i][j] = true;
                    DFS(j, i, board, visited);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    static void DFS(int x, int y, String[][] board, boolean[][] visited) {
        for (int i = 0; i < g_dir.length; i++) {
            int xMov = x + g_dir[i][0];
            int yMov = y + g_dir[i][1];

            if (yMov < 0 || yMov >= board.length
                || xMov < 0 || xMov >= board[0].length) {
                continue;
            }

            if (visited[yMov][xMov])
                continue;

            if (board[yMov][xMov].equals("0"))
                continue;

            visited[yMov][xMov] = true;
            DFS(xMov, yMov, board, visited);
        }
    }
}