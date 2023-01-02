import java.util.*;
public class Main {
    public static void main(String[] args) {
        String input1 = new Scanner(System.in).nextLine();
        String[] inputs = input1.split(" ");

        String first = inputs[0];
        String second = inputs[1];

        StringBuilder firstReverseBuf = new StringBuilder();
        StringBuilder secondReverseBuf = new StringBuilder();

        for (int i = first.length() - 1; i >= 0; i--)
            firstReverseBuf.append(first.charAt(i));

        for (int i = second.length() - 1; i >= 0; i--)
            secondReverseBuf.append(second.charAt(i));

        if ((Integer.parseInt(firstReverseBuf.toString()) > Integer.parseInt(secondReverseBuf.toString())))
            System.out.println(firstReverseBuf.toString());
        else
            System.out.println(secondReverseBuf.toString());
    }
}