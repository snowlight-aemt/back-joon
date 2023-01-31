import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] inputOne = input.readLine().split(" ");
        int count = Integer.valueOf(inputOne[0]);
        cnt = Integer.valueOf(inputOne[1]);

        arrTemp = new int[count];
        int[] arr = new int[count];

        String[] list = input.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.valueOf(list[i]);
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(result);
    }

    public static void mergeSort(int[] arr, int first, int last) {
        if (result != -1) return;

        if (first < last) {
            int middle = ((first + last) / 2);
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
    }

    public static int cnt = 0;

    public static int result = -1;

    public static int[] arrTemp ;

    public static void merge(int[] arr, int first, int middle, int last) {
        int lfirst = first;
        int rfirst = middle + 1;
        int arrTeampIndex = 0;

        while (lfirst <= middle && rfirst <= last) {
            if (arr[lfirst] < arr[rfirst]) {
                arrTemp[arrTeampIndex++] = arr[lfirst];
                lfirst++;
            } else {
                arrTemp[arrTeampIndex++] = arr[rfirst];
                rfirst++;
            }
        }

        while (lfirst <= middle)
            arrTemp[arrTeampIndex++] = arr[lfirst++];

        while (rfirst <= last)
            arrTemp[arrTeampIndex++] = arr[rfirst++];

        int idx = 0;
        for (int i = first; i <= last; i++) {
            if (--cnt == 0) {
                result = arrTemp[idx];
                break ;
            }
            arr[i] = arrTemp[idx++];
        }
    }
}