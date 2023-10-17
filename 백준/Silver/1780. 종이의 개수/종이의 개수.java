import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] board = null;
    static int zore = 0;
    static int plus = 0;
    static int minus = 0;

    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(input.readLine());
        board = new String[n][n];
                
        for (int i = 0; i < n; i++) {
            board[i] =  input.readLine().split(" ");
        }

        repeat(0, 0, n);

        System.out.println(minus);
        System.out.println(zore);
        System.out.println(plus);

    }

    public static void repeat(int x, int y, int size) {
        if (check(x, y, size)) {
            if (board[y][x].equals("0")) zore++;
            else if (board[y][x].equals("1")) plus++;
            else if (board[y][x].equals("-1")) minus++;

            return;
        }

        int tSize = size / 3;
        repeat(x, y, tSize);
        repeat(x + tSize, y, tSize);
        repeat(x + tSize + tSize, y, tSize);

        int y2 = y + tSize;
        repeat(x, y2, tSize);
        repeat(x + tSize, y2, tSize);
        repeat(x + tSize + tSize, y2, tSize);

        int y3 = y2 + tSize;
        repeat(x, y3, tSize);
        repeat(x + tSize, y3, tSize);
        repeat(x + tSize + tSize, y3, tSize);
    }

    public static boolean check(int x, int y, int size) {
        String initNum = board[y][x];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!initNum.equals(board[i+y][j+x])) {
                    return false;
                }
            }
        }
        return  true;
    }
}