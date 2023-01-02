import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] str = input.nextLine().split(" ");
        Integer n = Integer.parseInt(str[0]);
        Integer m = Integer.parseInt(str[1]);

        Integer[][] first = new Integer[n][m];
        Integer[][] second = new Integer[n][m];

        String line = "";
        for (int i = 0; i < n; i++ ) {
            line = input.nextLine();
            for (int j = 0; j < m; j++) {
                first[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }

        for (int i = 0; i < n; i++ ) {
            line = input.nextLine();
            for (int j = 0; j < m; j++) {
                second[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++) {
                System.out.print(first[i][j] + second[i][j] + " ");
            }
            System.out.println();
        }
    }
}