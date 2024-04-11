import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
        List<Integer> array = new ArrayList<>();
        array.addAll(List.of(0, 1, 2, 4));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = array.size(); j < n + 1; j++) {
                int total = array.get(j - 1) + array.get(j - 2) + array.get(j - 3);
                array.add(total);
            }

            System.out.println(array.get(n));
        }
	}
}
