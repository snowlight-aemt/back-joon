import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
//        String[] nArr = input.readLine().split(" ");

        int[] nArr = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine(), " ");
		for(int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}

//        List<Integer> list = Arrays.stream(nArr).sorted().map(Integer::parseInt).collect(Collectors.toList());
        Arrays.sort(nArr);

        int m = Integer.parseInt(input.readLine());
//        String[] mArr = input.readLine().split(" ");
        st = new StringTokenizer(input.readLine(), " ");

        StringBuilder sb = new StringBuilder();
//        Arrays.stream(mArr).forEach(x -> {
//            int value = Integer.parseInt(x);
//            int idx = findNum(nArr, value);
//
//            if (idx != -1) {
//                sb.append(1).append('\n');
//            } else {
//                sb.append(0).append('\n');
//            }
//        });
		for(int i = 0; i < m; i++) {

			// 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
			if(findNum(nArr, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}

        System.out.println(sb);
    }

    public static int findNum(int[] numbers, int value) {
        int l = 0;
        int r = numbers.length-1;
        int mid = 0;

        while (l <= r) {
            mid = (l + r) / 2;

            if (value < numbers[mid]) {
                r = mid - 1;
            } else if (value > numbers[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
