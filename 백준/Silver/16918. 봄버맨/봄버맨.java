import java.io.*;
import java.util.*;

public class Main {

    static int r, c, n;
    static String[][] maps, initBomb;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        r = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());
        maps = new String[r][c];
        initBomb = new String[r][c];

        for (int i = 0; i < r; i++) {
            maps[i] = br.readLine().split("");
            Arrays.fill(initBomb[i], "O");
        }

        maps = getMapsByTime(n);
        for (int i = 0; i < r; i++) {
            System.out.println(String.join("", maps[i]));
        }
    }

    private static String[][] getMapsByTime(int n) {
        if (n == 1) {
            return maps;
        }
        if (n % 2 == 0) {
            return initBomb;
        }
        if (n % 4 == 3) {
            return bomber();
        }
        if (n % 4 == 1) {
            maps = bomber();
            return bomber();
        }

        return maps;
    }

    private static String[][] bomber() {
        String[][] bomb = new String[r][c];
        for (int i = 0; i < r; i++) {
            bomb[i] = initBomb[i].clone();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maps[i][j].equals("O")) {
                    bomb[i][j] = ".";
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                            bomb[nx][ny] = ".";
                        }
                    }
                }
            }
        }

        return bomb;
    }
}
