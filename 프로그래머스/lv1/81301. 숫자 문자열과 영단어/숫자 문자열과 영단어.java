import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        System.out.println(s);
        
        Map<String, Integer> words = new HashMap<>() {{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};
        
        Collection<String> wordset = words.keySet();
        Iterator<String> iterator = wordset.iterator();

        String answerStr = s;
        while(iterator.hasNext()) {
            String key = iterator.next();
            if (answerStr.contains(key)) {
                answerStr = answerStr.replace(key, words.get(key).toString());
            }
        }
        
        answer = Integer.valueOf(answerStr);
        return answer;
    }
}