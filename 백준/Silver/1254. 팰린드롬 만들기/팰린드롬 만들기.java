import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) {
                System.out.println(s.length() + i);
                return;
            }
        }

        System.out.println(2 * s.length() - 1);
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() -i - 1)) {
                return false;
            }
        }

        return true;
    }
}
