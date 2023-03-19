import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = input.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // 듣도 못한
        int m = Integer.parseInt(firstLine[1]); // 보도 못한

        String [] nArr = new String[n];
//        String [] mArr = new String[m];
        List<String> list = new ArrayList<>();
        Map<String, Boolean> mMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            nArr[i] = input.readLine();
        }

        int size = 0;
        for (int i = 0; i < m; i++) {
            mMap.put(input.readLine(), false);
        }

        for (int i = 0; i < n; i++) {
            String str = nArr[i];
            Boolean aBoolean = mMap.get(str);
            if (aBoolean != null) {
                size++;
                list.add(str);
            }
        }

        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        list.forEach(v -> {
            sb.append(v).append('\n');
        });

        System.out.println(size);
        System.out.println(sb);
    }
}