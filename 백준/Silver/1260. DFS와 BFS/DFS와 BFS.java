import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    static int[] box;
    static int[][] edgeArr;
    static int[] answer;
    static boolean[] visited;
    static boolean[] bfsvisited;
    static int answerCnt = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] boxStrArr = input.readLine().split(" ");
        box = new int[boxStrArr.length];
        for (int i = 0; i < boxStrArr.length; i++) {
            box[i] = Integer.parseInt(boxStrArr[i]);
        }

        int nodeCnt = box[0];
        int edgeCnt = box[1];
        int nodeStartPoint = box[2];

        edgeArr = new int[edgeCnt][2];
        for (int i = 0; i < edgeCnt; i++) {
            String[] edgeStrArr = input.readLine().split(" ");
            edgeArr[i][0] = Integer.parseInt(edgeStrArr[0]);
            edgeArr[i][1] = Integer.parseInt(edgeStrArr[1]);
        }

//==
        // box = new int[] { 5, 5, 3 };
        // int nodeCnt = box[0];
        // int edgeCnt = box[1];
        // int nodeStartPoint = box[2];
        // // static int[][] edgeArr = {{1, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}};
        // edgeArr = new int[][] {{5, 4}, {5, 2}, {1, 2}, {3, 4}, {3, 1}};
//==

        for (int i = 0; i < edgeCnt; i++) {
            int leftNode = edgeArr[i][0];
            int rightNode = edgeArr[i][1];
            
            if (map.get(leftNode) == null) {
                map.put(leftNode, new ArrayList<>());
            }
            if (map.get(rightNode) == null) {
                map.put(rightNode, new ArrayList<>());
            }

            map.get(leftNode).add(rightNode);
            map.get(rightNode).add(leftNode);
        }

        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            map.get(key).sort((a, b) -> {
                return a - b;
            });

        }

        answer = new int[nodeCnt];

        visited = new boolean[nodeCnt + 1];
        visited[nodeStartPoint] = true;
        DFS(nodeStartPoint);

        for (int i = 0; i < answerCnt; i++) {
            System.out.print(answer[i] + " ");
        }

        answerCnt = 0;
        bfsvisited = new boolean[nodeCnt + 1];
        bfsvisited[nodeStartPoint] = true;
        queue.add(nodeStartPoint);
        BFS();

        System.out.println();
        for (int i = 0; i < answerCnt; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static void DFS(int nodeLoc) {
        answer[answerCnt++] = nodeLoc;

        List<Integer> list = map.get(nodeLoc);
        if (list == null) return; 
        for (Integer i : list) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }

        return;
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int nodeLoc = queue.poll();
            answer[answerCnt++] = nodeLoc;
            
            List<Integer> list = map.get(nodeLoc);
            if (list == null) return; 
            for (Integer i : list) {
                if (!bfsvisited[i]) {
                    bfsvisited[i] = true;
                    queue.add(i);
                }
            }
        }
        return;
    }
}