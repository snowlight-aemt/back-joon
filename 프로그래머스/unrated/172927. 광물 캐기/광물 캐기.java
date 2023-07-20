import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    // [0, 1, 0] ["diamond", "iron", "iron", "iron", "iron", "diamond", "diamond", "iron", "iron", "iron"] 9 
    // [1, 1, 0],  ["iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond"] 12
    // [1, 0, 1] , ["iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"] 47
    public int solution(int[] picks, String[] minerals) {
        int pickCnt = Arrays.stream(picks).sum();
        int answer = 0;

        List<Map<String, Integer>> grid = new ArrayList<>();
        grid.add(Map.of("diamond", 1, "iron", 1, "stone", 1));
        grid.add(Map.of("diamond", 5, "iron", 1, "stone", 1));
        grid.add(Map.of("diamond", 25, "iron", 5, "stone", 1));

        List<List<Integer>> result = new ArrayList<>();
        int _d = 0, _i = 0, _s = 0;
        for (int i = 0; i < minerals.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < picks.length; j++) {
                Integer score = grid.get(j).get(minerals[i]);
                temp.add(score);
            }

            _d += temp.get(0);
            _i += temp.get(1);
            _s += temp.get(2);

            if ((i != 0 && ((i + 1) % 5) == 0)) {
                if (pickCnt-- == 0) break;

                result.add(List.of(_d, _i, _s));
                _d = 0; _i = 0; _s = 0;
            }
        }

        if (minerals.length % 5 != 0) {
            result.add(List.of(_d, _i, _s));
        }

        List<List<Integer>> list = result.stream().sorted((o1, o2) -> {
            return o2.get(2) - o1.get(2);
        }).collect(Collectors.toList());
        
        for (int i = 0; i < list.size(); i++) {
            if (picks[0] > 0) {
                picks[0]--;
                answer += list.get(i).get(0);

            } else if (picks[1] > 0) {
                picks[1]--;
                answer += list.get(i).get(1);

            } else if (picks[2] > 0) {
                picks[2]--;
                answer += list.get(i).get(2);
                
            }
        }

        return answer;
    }
}
