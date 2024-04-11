import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int[] scores = new int[n];
        if (n == 1) {
            System.out.println(array[0]);
            return;
        }
        if (n == 2) {
            System.out.println(array[0] + array[1]);
            return;
        }

        scores[0] = array[0];
        scores[1] = array[0] + array[1];
        scores[2] = Math.max(array[0], array[1]) + array[2];
        for (int i = 3; i < n; i++) {
            scores[i] = array[i] + Math.max(scores[i - 2], array[i - 1] + scores[i - 3]);
        }

        System.out.println(scores[n - 1]);
	}
}
