import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int n;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(n);
            temp.add(i);

            while (true) {
                int size = temp.size();
                int first = temp.get(size - 2);
                int second = temp.get(size - 1);

                if (first - second < 0) {
                    break;
                }

                temp.add(first - second);
            }

            if (temp.size() > answer.size()) {
                answer.clear();
                answer.addAll(temp);
            }
        }

        System.out.println(answer.size());
        StringBuffer sb = new StringBuffer();
        for (Integer num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
}
