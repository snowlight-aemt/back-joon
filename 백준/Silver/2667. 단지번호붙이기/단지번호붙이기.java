import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] nArr;
    static List<Integer> answers = new ArrayList<>();
    static int answerIdx = 0;
    static int nArrCnt;
    public static void main(String[] args) throws IOException {
        // int[] answer = new int[];

        // nArrCnt = 7;
        // String[] nStr = {
        //     "0110100",
        //     "0110101",
        //     "1110101",
        //     "0000111",
        //     "0100000",
        //     "0111110",
        //     "0111000"
        // };

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        nArrCnt = Integer.parseInt(input.readLine());
        
        String[] nStr = new String[nArrCnt];
        for (int i = 0; i < nArrCnt; i++) {
            nStr[i] = input.readLine();
        }

        visited = new boolean[nArrCnt][nArrCnt];
        nArr = new int[nArrCnt][nArrCnt];

        for (int i = 0; i < nArrCnt; i++) {
            for (int j = 0; j < nArrCnt; j++) {
                nArr[i][j] = Character.getNumericValue(nStr[i].charAt(j));
            }
        }

        for (int i = 0; i < nArrCnt; i++) {
            for (int j = 0; j < nArrCnt; j++) {
                if (nArr[i][j] == 0 || visited[i][j])
                    continue;
                    
                answerIdx = 0;

                visited[i][j] = true;
                DFS(j, i);    
                
                answers.add(answerIdx);
            }
        }

        answers.sort((a, b) -> a - b);
        System.out.println(answers.size());
        answers.forEach(System.out::println);
    }

    static void DFS(int col, int row) {
        answerIdx++;

        for (int i = 0; i < direction.length; i++) {
            int dCol = col + direction[i][0];
            int dRow = row + direction[i][1];
            if (doesNotMove(dCol, dRow)) {
                continue;
            }
    
            visited[dRow][dCol] = true;
            DFS(dCol, dRow);
        }
    }

    private static boolean doesNotMove(int col, int row) {
        if (row < 0 || col < 0 
                || row >= nArrCnt || col >= nArrCnt 
                || nArr[row][col] == 0) {
            return true;
        }

        if (visited[row][col]) {
            return true;
        }

        return false;
    }
}