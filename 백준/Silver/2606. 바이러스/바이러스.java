import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int computer = 0;
    static int computerEdge = 0;
    static String[] edgeArr;

    static boolean[][] computerNetworks;
    static boolean[] visited;
    
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(input.readLine());
        computerEdge = Integer.parseInt(input.readLine());
        edgeArr = new String[computerEdge];
        computerNetworks = new boolean [computer + 1][computer + 1];
        visited = new boolean[computer+1];

        if (computer == 0 || computerEdge == 0) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < computerEdge; i++) {
            edgeArr[i] = input.readLine();
        }

        for (int i = 0; i < computerEdge; i++) {
            String[] edge = edgeArr[i].split(" ");
            
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);

            computerNetworks[x][y] = computerNetworks[y][x] = true;
        }

        int startC = 1;
        visited[startC] = true;

        DFS(startC);
        
        System.out.println(answer);
    }

    public static void DFS(int startC) {
        for (int i = 1; i < computer + 1; i++) {
            if ((computerNetworks[i][startC] || computerNetworks[startC][i]) 
                    && !visited[i]) {
                visited[i] = true;
                answer++;

                DFS(i);
            }
        }
    }
}
