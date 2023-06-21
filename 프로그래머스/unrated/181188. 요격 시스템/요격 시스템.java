import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        // 1. 시작점이 작은 순으로 정렬 
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o, int[] o1){
                 return o[1] - o1[1];      
            }
        });

        // 선두에 있는 E 보다 시작점이 작으면 = 같이 요격 가능 
        int now = targets[0][1];
        for(int i = 1; i < targets.length; i++){
            if(targets[i][0] < now){ // 같이 요격 가능 
                continue;
            } else {
                answer++; 
                now = targets[i][1];
            }
        }
        
        return answer;
    }
}