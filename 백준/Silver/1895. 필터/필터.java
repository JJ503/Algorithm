import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int r, c, t;
    static int[][] maps;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());

        r = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());

        maps = new int[r][c];
        for (int i = 0; i < r; i++) {
            str = new StringTokenizer(br.readLine());

            for (int j = 0; j < c; j++) {
                maps[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        t = Integer.parseInt(br.readLine());

        int[][] filterImage = new int[r - 2][c - 2];
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                filterImage[i][j] = getFilterNumber(i, j);
            }
        }

        int answer = 0;
        for (int i = 0; i < filterImage.length; i++) {
            for (int j = 0; j < filterImage[i].length; j++) {
                if (filterImage[i][j] >= t) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static int getFilterNumber(int x, int y) {
        int[] temp = new int[9];
        int idx = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                temp[idx++] = maps[i][j];
            }
        }

        Arrays.sort(temp);

        return temp[4];
    }
}
