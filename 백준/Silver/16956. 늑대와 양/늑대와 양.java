import java.util.*;
import java.io.*;

public class Main {

    static int r, c;
    static String[][] maps;
    static int[] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        r = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());
        maps = new String[r][c];

        for (int i = 0; i < r; i++) {
            maps[i] = br.readLine().split("");
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maps[i][j].equals("S")) {
                    boolean canClose = canWolvesClose(i, j);
                    if (canClose) {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(maps[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static boolean canWolvesClose(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                if (maps[nx][ny].equals("W")) {
                    return true;
                }
                if (maps[nx][ny].equals(".")) {
                    maps[nx][ny] = "D";
                }
            }
        }

        return false;
    }
}
