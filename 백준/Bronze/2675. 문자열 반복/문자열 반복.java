import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer count = Integer.parseInt(s.nextLine());

//        Integer count = 1;

        List<String> result = new ArrayList<>();

        while (count > 0) {

            String[] repeatWord = s.nextLine().split(" ");

//            String[] repeatWord = "3 ABC".split(" ");
            Integer repeatNum = Integer.parseInt(repeatWord[0]);
            String word = repeatWord[1];
//
            String temp = "";
            for (char c : word.toCharArray()) {
                for (int i = 0; i < repeatNum; i++) {
                    temp += c;
                }
            }
            result.add(temp);

            count--;
        }

        for (String str : result) {
            System.out.println(str);
        }
    }
}