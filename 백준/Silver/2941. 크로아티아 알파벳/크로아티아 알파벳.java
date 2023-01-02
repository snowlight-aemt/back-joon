import java.util.*;
public class Main {
    public static void main(String[] args) {
        String input1 = new Scanner(System.in).nextLine();
        String[] words = new String[] {"c=","c-","dz=","d-","lj","nj","s=","z="};

        String replaceWord = input1;
        for (String word : words)
            replaceWord = replaceWord.replace(word, "K");

        System.out.println(replaceWord.length());
    }
}