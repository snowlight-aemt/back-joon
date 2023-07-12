import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int cnt = 0;

        Stack<String[]> stack = new Stack<>();

        Arrays.sort(plans, (c, p) -> {
            return getMinute(c[1]) - getMinute(p[1]);
        });

        
//[["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"],["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
// music computer science history
        for (int i = 0; i < plans.length; i++) {
            String[] curPlan = plans[i];

            while (!stack.empty()) {
                String[] prevPlan = stack.pop();
            
                int prevPlanEndTime = getMinute(prevPlan[1]) + Integer.parseInt(prevPlan[2]);
                int curPlanStartTime = getMinute(curPlan[1]);

                // if (prevPlanEndTime == curPlanStartTime) {
                //     answer[cnt++] = curPlan[0];
                //     answer[cnt++] = prevPlan[0];
                // } else if (prevPlanEndTime < curPlanStartTime) {
                //     answer[cnt++] = prevPlan[0];
                // } else {
                //     prevPlan[2] = String.valueOf(prevPlanEndTime - curPlanStartTime);
                //     stack.push(prevPlan);
                //     break;
                // }

                if (prevPlanEndTime <= curPlanStartTime) {
                    answer[cnt++] = prevPlan[0];
                } else {
                    prevPlan[2] = String.valueOf(prevPlanEndTime - curPlanStartTime);
                    stack.push(prevPlan);
                    break;
                }
            }

            stack.push(curPlan);
        }

        while (!stack.empty()) {
            answer[cnt++] = stack.pop()[0];
        }

        Arrays.stream(answer).forEach(v -> {
            System.out.println(v);
        });

        return answer;
    }

    private static int getMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}