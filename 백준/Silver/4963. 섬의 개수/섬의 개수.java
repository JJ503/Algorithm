import java.io.*;
import java.util.*;

public class Main {

    static int w, h;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        
        while (true) {
            str = new StringTokenizer(br.readLine());
            w = Integer.parseInt(str.nextToken());
            h = Integer.parseInt(str.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            maps = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                str = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < w; j++) {
                    maps[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            System.out.println(countIsland());
        }
    }

    private static int countIsland() {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
