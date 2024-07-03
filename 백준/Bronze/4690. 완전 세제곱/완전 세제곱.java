import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    static BufferedReader br;
    static StringTokenizer str;

    public static void main(String[] args) throws IOException {

        for (int a = 2; a < 101; a++) {
            for (int b = 2; b < 101; b++) {
                for (int c = b + 1; c < 101; c++) {
                    for (int d = c; d < 101; d++) {
                        int aTemp = triple(b) + triple(c) + triple(d);
                        if (triple(a) == aTemp) {
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d);
                        }
                    }
                }
            }
        }
    }

    private static int triple(int x) {
        return (int) Math.pow(x, 3);
    }
}
