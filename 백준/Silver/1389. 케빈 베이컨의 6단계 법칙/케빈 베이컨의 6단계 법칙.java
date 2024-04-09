import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] array;
	static int[] counts;
    static int n, m, count;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		array = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) {
			array[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			array[a].add(b);
			array[b].add(a);
		}
		
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for(int i = 1; i <= n; i++) {
            int counts = bfs(i);

            if(min > counts) {
				min = counts;
				answer = i;
			}
		}

		System.out.println(answer);
	}
	
	static int bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next: array[current]) {
                if (dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[current] + 1;
                count += dist[next];
                queue.add(next);
            }
        }

        return count;
	}
}
