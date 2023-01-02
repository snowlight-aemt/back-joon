import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer count = Integer.parseInt(scanner.nextLine());
        String[] input = new String[count];
        for (int i = 0; i < count; i++) {
            input[i] = scanner.nextLine();
        }

        int MAX_POS_X = 100;
        int MAX_POS_Y = 100;

        int[][] board = new int[MAX_POS_X][MAX_POS_Y];

        for (int i = 0; i < count; i++) {
            int xs = Integer.valueOf(input[i].split(" ")[0]);
            int ys = Integer.valueOf(input[i].split(" ")[1]);
            for (int x = 0 + xs; x < 10 + xs; x++) {
                for (int y = 0 + ys; y < 10 + ys; y++) {
                    board[x][y]++;
                }
            }
        }

        int sum = 0;

        for (int x = 0; x < MAX_POS_X; x++) {
            for (int y = 0; y < MAX_POS_Y; y++) {
                if (board[x][y] == 0) continue;
                sum += 1;
            }
        }

        System.out.println(sum);
    }
}