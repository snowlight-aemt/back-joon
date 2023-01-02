import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int count = Integer.parseInt(input.readLine());

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        List<Pos> poses = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String pox[] = input.readLine().split(" ");
            int x = Integer.parseInt(pox[0]);
            int y = Integer.parseInt(pox[1]);

            poses.add(new Pos(x, y));
        }

        poses.sort((a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return a.y - b.y;
        });

        for (int i = 0; i < count; i++) {
            sb.append(poses.get(i).x + " " + poses.get(i).y);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}


