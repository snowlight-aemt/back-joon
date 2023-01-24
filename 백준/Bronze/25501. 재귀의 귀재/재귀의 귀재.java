import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine());


        for (int i = 0; i < count; i++) {
            cnt = 0;
            System.out.print(isPalindrome(input.readLine()) + " ");
            System.out.println(cnt);
        }
    }
    
    public static int recursion(String s, int l, int r){
        cnt += 1;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}