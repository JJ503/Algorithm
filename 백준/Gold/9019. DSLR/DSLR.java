import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;
    static int t, a, b;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            str = new StringTokenizer(br.readLine());
            a = Integer.parseInt(str.nextToken());
            b = Integer.parseInt(str.nextToken());
            visited = new boolean[10000];

            Queue<Register> queue = new LinkedList<>();
            queue.add(new Register(a, ""));
            while (!queue.isEmpty()) {
                Register now = queue.poll();

                if (now.isSameNum(b)) {
                    System.out.println(now.command);
                    break;
                }

                int resultD = now.D();
                int resultS = now.S();
                int resultL = now.L();
                int resultR = now.R();

                if (!visited[resultD]) {
                    queue.add(new Register(resultD, now.command + "D"));
                    visited[resultD] = true;
                }
                if (!visited[resultS]) {
                    queue.add(new Register(resultS, now.command + "S"));
                    visited[resultS] = true;
                }
                if (!visited[resultL]) {
                    queue.add(new Register(resultL, now.command + "L"));
                    visited[resultL] = true;
                }
                if (!visited[resultR]) {
                    queue.add(new Register(resultR, now.command + "R"));
                    visited[resultR] = true;
                }
            }
        }
    }

    static class Register {
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D() {
            return (num) * 2 % 10000;
        }

        int S() {
            if (num == 0) {
                return 9999;
            }

            return num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
        }

        boolean isSameNum(int num) {
            return this.num == num;
        }
    }
}
