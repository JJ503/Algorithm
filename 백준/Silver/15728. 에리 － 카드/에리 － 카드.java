import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n, k;
    static ArrayList<Integer> shareCards, teamCards;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());

        shareCards = new ArrayList<>();
        teamCards = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            shareCards.add(Integer.parseInt(str.nextToken()));
        }
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            teamCards.add(Integer.parseInt(str.nextToken()));
        }

        for (int cnt = 0; cnt < k; cnt++) {
            int max = Integer.MIN_VALUE;
            int removeIdx = -1;
            
            for (int i = 0; i < shareCards.size(); i++) {
                for (int j = 0; j < teamCards.size(); j++) {
                    if (max <= shareCards.get(i) * teamCards.get(j)) {
                        max = shareCards.get(i) * teamCards.get(j);
                        removeIdx = j;
                    }
                }
            }

            teamCards.remove(removeIdx);
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < shareCards.size(); i++) {
            for (int j = 0; j < teamCards.size(); j++) {
                answer = Math.max(answer, shareCards.get(i) * teamCards.get(j));
            }
        }

        System.out.println(answer);
    }
}
