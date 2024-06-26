import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import javax.swing.event.ChangeEvent;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Baseball> baseballs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            int[] baseball = Stream.of(str.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            int strike = Integer.parseInt(str.nextToken());
            int ball = Integer.parseInt(str.nextToken());

            baseballs.add(new Baseball(baseball, strike, ball));
        }

        int answer = 0;
        for (int first = 1; first < 10; first++) {
            for (int second = 1; second < 10; second++) {
                for (int third = 1; third < 10; third++) {
                    if (isAvailableBaseBall(first, second, third)) {
                        int[] checkBaseball = new int[]{first, second, third};
                        boolean check = true;
                        for (Baseball baseball : baseballs) {
                            if (!baseball.isPossibleAnswer(checkBaseball)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isAvailableBaseBall(int a, int b, int c) {
        return a != b && b != c && a != c;
    }
}

class Baseball {

    int[] baseball;
    int strike;
    int ball;

    public Baseball(int[] baseball, int strike, int ball) {
        this.baseball = baseball;
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isPossibleAnswer(int[] checkBaseball) {
        int countStrike = 0;
        int countBall = 0;
        for (int i = 0; i < baseball.length; i++) {
            for (int j = 0; j < checkBaseball.length; j++) {
                if (i == j && baseball[i] == checkBaseball[j]) {
                    countStrike++;
                    break;
                }
                if (i != j && baseball[i] == checkBaseball[j]) {
                    countBall++;
                    break;
                }
            }
        }

        return strike == countStrike && ball == countBall;
    }
}
