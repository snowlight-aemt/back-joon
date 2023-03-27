import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        Deque<String> queue = new LinkedList<>();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            String[] command = input.readLine().split(" ");
            String operation = command[0];

            switch (operation) {
                case "push":
                    queue.add(command[1]);
                    break;
                case "pop":
                    if (queue.isEmpty()) stringBuffer.append("-1").append('\n');
                    else stringBuffer.append(queue.poll()).append('\n');
                    break;
                case "size":
                    stringBuffer.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) stringBuffer.append("1").append('\n');
                    else stringBuffer.append("0").append('\n');
                    break;
                case "front":
                    if (queue.isEmpty()) stringBuffer.append("-1").append('\n');
                    else stringBuffer.append(queue.element()).append('\n');
                    break;
                case "back":
                    if (queue.isEmpty()) stringBuffer.append("-1").append('\n');
                    else stringBuffer.append(queue.peekLast()).append('\n');
                    break;

            }
        }

        System.out.println(stringBuffer.toString());
    }

//    push X: 정수 X를 큐에 넣는 연산이다.
//    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    size: 큐에 들어있는 정수의 개수를 출력한다.
//    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
}