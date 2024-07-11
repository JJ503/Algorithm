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
        
        int x = Integer.parseInt(str.nextToken());
        int y = Integer.parseInt(str.nextToken());
        int p1 = Integer.parseInt(str.nextToken());
        int p2 = Integer.parseInt(str.nextToken());

        while (true) {
            if (p1 == p2) {
                System.out.println(p1);
                break;
            }
            if (p1 > 10000 || p2 > 10000) {
                System.out.println(-1);
                break;
            }
            if (p1 > p2) {
                p2 += y;
                continue;
            }
            if (p2 > p1) {
                p1 += x;
            }
        }
    }
}
