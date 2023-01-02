import java.util.Scanner;

public class Main {
    public final static Integer x = 9;
    public final static Integer y = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[][] board = new Integer[x][y];

        Integer maxNumber = 0;
        Integer maxPosX = 0;
        Integer maxPosY = 0;

        for (int i = 0; i < x; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < y; j++) {
                int currentNumber = Integer.parseInt(row[j]);

                if (currentNumber > maxNumber) {
                    maxNumber = currentNumber;
                    maxPosX = i;
                    maxPosY = j;
                }

                board[i][j] = currentNumber;
            }
        }

        System.out.println(maxNumber);
        System.out.print((maxPosX+1) + " " + (maxPosY+1));
    }
}
