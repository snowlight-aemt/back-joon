import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<Integer, Set<Integer>> g_board = new HashMap<>();
    static int[] parent;
    static int g_root = 1;
    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(input.readLine());
        parent = new int[nodeCnt + 1];
        
        for (int i = 1; i < nodeCnt; i++) {
            String[] enge = input.readLine().split(" ");
            int x = Integer.parseInt(enge[0]);
            int y = Integer.parseInt(enge[1]);
            
            if (g_board.get(x) == null) {
                Set<Integer> xSet = new HashSet<>();
                xSet.add(y);
                g_board.put(x, xSet);
            } else {
                g_board.get(x).add(y);
            }

            
            if (g_board.get(y) == null) {
                Set<Integer> ySet = new HashSet<>();
                ySet.add(x);
                g_board.put(y, ySet);
            } else {
                g_board.get(y).add(x);
            }
        }
        
        DFS(g_root);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    static void DFS(int currNodeNum) {
        Set<Integer> currNode = g_board.get(currNodeNum);
        for (Integer subNode : currNode) {
            if (parent[currNodeNum] == subNode) 
                continue;
            
            parent[subNode] = currNodeNum;
            DFS(subNode);
        }
    }
}
