import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");

        for (int cnt = 0; cnt < n; cnt++) {
            String str = br.readLine();

            if (checkPattern(str, pattern)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

    private static boolean checkPattern(String str, String[] pattern) {
        int strLength = str.length();
        int pattern1Length = pattern[0].length();
        int pattern2Length = pattern[1].length();

        for (int i = 0; i < pattern1Length; i++) {
            if (str.charAt(i) != pattern[0].charAt(i)) {
                return false;
            }
        }

        for (int i = 0; i < pattern2Length; i++) {
            if (strLength - i <= pattern1Length) {
                return false;
            }
            if (str.charAt(strLength - 1 - i) != pattern[1].charAt(pattern2Length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
