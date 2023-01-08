import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(input.readLine());
        int[] counter = new int[8001];

        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(input.readLine());
            counter[getIdx(numbers[i])] += 1;
        }

        int average = 0;
        int orderedCount = 0;
        int[] numbersOrdered = new int [count];
        int maxFrequency = Integer.MIN_VALUE;
        for (int i = 0; i < 8001; i++) {
            int incrementCounter = counter[i];
            if (incrementCounter == 0)
                continue;


            for (int j = incrementCounter; j > 0; j--) {
                numbersOrdered[orderedCount++] = getVal(i);
                average += getVal(i);
            }

            // 빈도수
            if (maxFrequency < incrementCounter) {
                maxFrequency = incrementCounter;
            }
        }

        int maxFrequencyFirstNumberOrSecond = 0;
        int maxFrequencyFirstNumberOrSecondCount = 0;
        for (int i = 0; i < 8001; i++) {
            int incrementCounter = counter[i];
            if (maxFrequency > incrementCounter)
                continue;

            maxFrequencyFirstNumberOrSecond = getVal(i);
            maxFrequencyFirstNumberOrSecondCount++;

            if (maxFrequencyFirstNumberOrSecondCount == 2) break;
        }

        // 평균값
        System.out.println((int)Math.round((double) average / orderedCount));
        // 중앙값
        System.out.println(numbersOrdered[(orderedCount/2)]);
        // 빈수
        System.out.println(maxFrequencyFirstNumberOrSecond);
        // 최대 최소 차이값
        System.out.println(numbersOrdered[orderedCount - 1] - numbersOrdered[0]);
    }

    public static int getIdx(int value) {
        return value + 4000;
    }

    public static int getVal(int value) {
        return value - 4000;
    }
}