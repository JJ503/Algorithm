import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        String k = str.nextToken();

        int answer = 0;
        for (int h = 0; h <= n; h++) {
            String hour = String.format("%02d", h);
            for (int m = 0; m < 60; m++) {
                String minute = String.format("%02d", m);
                for (int s = 0; s < 60; s++) {
                    String second = String.format("%02d", s);
                    String time = hour + minute + second;
                    if (time.contains(k)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
