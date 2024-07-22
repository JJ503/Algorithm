import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (!(str = br.readLine()).equals("0")) {
            System.out.println(getCountForPalindrome(str));
        }
    }

    private static int getCountForPalindrome(String str) {
        int count = 0;
        int strLenght = str.length();

        while (!isPalindrome(str)) {
            int num = Integer.valueOf(str);
            num++;
            str = String.valueOf(num);
            
            int needZeroSize = strLenght - str.length();
            for (int i = 0; i < needZeroSize; i++) {
                str = "0" + str;
            }

            count++;
        }

        return count;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
