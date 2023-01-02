import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(input.readLine());

        List<String[]> members = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] words = new String[3];
            String[] temp = input.readLine().split(" ");
            words[0] = temp[0];
            words[1] = temp[1];
            words[2] = String.valueOf(i);
            members.add(words);
        }

        members.<String>sort((s1, s2) -> {
            int s1Age = Integer.parseInt(s1[0]);
            int s2Age = Integer.parseInt(s2[0]);
            int s1No = Integer.parseInt(s1[2]);
            int s2No = Integer.parseInt(s2[2]);

            if (s1Age == s2Age)
                return s1No - s2No;

            return s1Age - s2Age;
        });

        for (String[] words: members) {
            sb.append(words[0] + " " + words[1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}