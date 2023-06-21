import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int endCur = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            int srcNext = targets[i][0];
            if (endCur <= srcNext) {
                endCur = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}