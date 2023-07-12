import java.io.IOException;
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

        for (int i = 0; i < plans.length; i++) {
            String[] curPlan = plans[i];
            int additivityPlanEndTime = 0;

            while (!stack.empty()) {
                String[] prevPlan = stack.pop();
                // TODO 약간 코드가 지저분하다.. 고민 중....
                // 첫 작업 이후에는 다음 작업을 진행할 때 이전 작업(첫 작업...) 에서 사용한 시간을 계산해야 한다.
                int prevPlanEndTime = additivityPlanEndTime == 0 
                    ? getMinute(prevPlan[1]) + Integer.parseInt(prevPlan[2]) 
                    : additivityPlanEndTime + Integer.parseInt(prevPlan[2]);
                int curPlanStartTime = getMinute(curPlan[1]);
                

                if (prevPlanEndTime <= curPlanStartTime) {
                    answer[cnt++] = prevPlan[0];
                    additivityPlanEndTime = prevPlanEndTime;
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
