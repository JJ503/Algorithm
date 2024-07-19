import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static String documents, target;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        documents = br.readLine();
        target = br.readLine();

        int answer = 0;
        for (int startIndex = 0; startIndex <= documents.length() - target.length(); startIndex++) {
            int endIndex = startIndex + target.length();
            String search = documents.substring(startIndex, endIndex);

            if (search.equals(target)) {
                answer++;
                startIndex = endIndex - 1;
            }
        }

        System.out.println(answer);
    }
}
