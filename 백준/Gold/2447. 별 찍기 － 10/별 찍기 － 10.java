import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    static char[][] canvas;
    static StringBuffer result = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        canvas = new char[n][n];

        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(canvas[i][j]);
//                System.out.print();
            }
            result.append('\n');
        }

        System.out.print(result);
    }

    private static void star(int x, int y, int n, boolean isBlock) {

        if (isBlock) {
            for (int i = y; i < y+n; i++) {
                for (int j = x; j < x+n; j++) {
                    canvas[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            canvas[y][x] = '*';
            return;
        }

        int count = 0;
        for (int i = y; i < y + n; i+=(n /3)) {
            for (int j = x; j < x + n; j+=(n /3)) {
                count++;
                if (count == 5)
                    star(j, i, n /3, true);
                else
                    star(j, i, (n /3), false);
            }
        }
    }
}