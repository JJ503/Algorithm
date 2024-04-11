import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx & nx <= n & 0 <= ny & ny <= m) {
                    if (maps[nx][ny] == 1) {
                        maps[nx][ny] = maps[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        if (maps[n][m] == 1) {
            return -1;
        }
        
        return maps[n][m];
    }
}