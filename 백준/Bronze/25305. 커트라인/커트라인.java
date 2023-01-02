import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lineOne = "";
        String lineTwo = "";

        lineOne = input.nextLine();
        lineTwo = input.nextLine();

        int count = Integer.parseInt(lineOne.split(" ")[0]);
        int successfulCandidate = Integer.parseInt(lineOne.split(" ")[1]);

        int[] score = new int[count];
        for (int i = 0; i < count; i++) {
            score[i] = Integer.parseInt(lineTwo.split(" ")[i]);
        }

        int temp = 0;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i; j < count; j++) {
                if (score[i] < score[j]) {
                    temp = score[j];
                    score[j] = score[i];
                    score[i] = temp;
                }
            }
        }

        System.out.println(score[successfulCandidate-1]);
    }
}