import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br;
    static int n;
    static String[] words;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canPair(words[i], words[j])) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean canPair(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int[] changeAlpha = new int[26];
        Arrays.fill(changeAlpha, -1);
        boolean[] visited = new boolean[26];
        for (int i = 0; i < str1.length; i++) {
            int str1Index = str1[i] - 'a';
            int str2Index = str2[i] - 'a';

            if (changeAlpha[str1Index] == -1) {
                if (visited[str2Index]) {
                    return false;
                }

                changeAlpha[str1Index] = str2Index;
                visited[str2Index] = true;
                continue;
            }

            if (changeAlpha[str1Index] != str2Index) {
                return false;
            }
        }

        return true;
    }
}
