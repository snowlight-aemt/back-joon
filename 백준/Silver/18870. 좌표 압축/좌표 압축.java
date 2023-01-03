import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(input.readLine());

        Integer[] posXList = new Integer[count];
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        String[] temp = input.readLine().split(" ");

        for (int i = 0; i < count; i++) {
            posXList[i] = Integer.parseInt(temp[i]);
            set.add(Integer.parseInt(temp[i]));
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(a -> a));

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < posXList.length; i++) {
            posXList[i] = map.get(posXList[i]);
        }

        for (Integer posX: posXList) {
            sb.append(posX);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}