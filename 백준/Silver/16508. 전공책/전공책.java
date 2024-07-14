import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static String t;
    static int n, answer = Integer.MAX_VALUE;
    static int[] count = new int[26];
    static int[] selectCount = new int[26];
    static Book[] books;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        
        t = br.readLine();
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'A']++;
        }

        n = Integer.parseInt(br.readLine());
        books = new Book[n];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(str.nextToken());
            String title = str.nextToken();
            books[i] = new Book(title, cost);
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    private static void dfs(int index, int total) {
        if (index == n) {
            if (check()) {
                answer = Math.min(answer, total);
            }
            return;
        }

        String title = books[index].getTitle();
        for (int i = 0; i < title.length(); i++) {
            selectCount[title.charAt(i) - 'A']++;
        }
        dfs(index + 1, total + books[index].getCost());
        for (int i = 0; i < title.length(); i++) {
            selectCount[title.charAt(i) - 'A']--;
        }
        dfs(index + 1, total);
    }

    private static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (count[i] > selectCount[i]) {
                return false;
            }
        }

        return true;
    }
}

class Book {

    private String title;
    private int cost;

    public Book(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
