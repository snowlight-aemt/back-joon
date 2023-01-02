import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(input.readLine());

        Set<String> words = new HashSet<>();
        for (int i = 0; i < count; i++) {
            words.add(input.readLine());
        }

        List<String> orderedWords = words.stream()
                .sorted((s1, s2) -> {
                    if (s1.length() == s2.length()) {
                        return s1.compareTo(s2) ;
                    }
                    return s1.length() - s2.length();
                })
                .collect(Collectors.toList());

        for (String word : orderedWords) {
            sb.append(word);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}