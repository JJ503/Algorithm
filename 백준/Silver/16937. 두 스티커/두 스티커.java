import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int h, w;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        str = new StringTokenizer(br.readLine());
        
        h = Integer.parseInt(str.nextToken());
        w = Integer.parseInt(str.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[][] stickers = new int[n][3];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(str.nextToken());
            stickers[i][1] = Integer.parseInt(str.nextToken());
            stickers[i][2] = stickers[i][0] * stickers[i][1];
        }
        
        int answer = 0;
        for (int i = 0; i < stickers.length; i++) {
            for (int j = i + 1; j < stickers.length; j++) {
                if (canPutSticker(stickers[i], stickers[j])) {
                    int area = stickers[i][2] + stickers[j][2];
                    answer = Math.max(answer, area);
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean canPutSticker(int[] sticker1, int[] sticker2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int temp1 = sticker1[i] + sticker2[j];
                int temp2 = Math.max(sticker1[(i + 1) % 2], sticker2[(j + 1) % 2]);

                if (temp1 <= h && temp2 <= w) {
                    return true;
                }
                if (temp1 <= w && temp2 <= h) {
                    return true;
                }
            }
        }

        return false;
    }
}
