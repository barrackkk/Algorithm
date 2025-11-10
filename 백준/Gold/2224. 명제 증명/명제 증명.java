import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int SIZE = 52;
    static boolean[][] graph = new boolean[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char from = s.charAt(0);
            char to = s.charAt(5);
            int a = toIndex(from);
            int b = toIndex(to);
            graph[a][b] = true;
        }

        for (int k = 0; k < SIZE; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i != j && graph[i][j]) {
                    sb.append(toChar(i)).append(" => ").append(toChar(j)).append("\n");
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.print(sb);
    }

    static int toIndex(char c) {
        if ('A' <= c && c <= 'Z') {
            return c - 'A';
        } else {
            return c - 'a' + 26;
        }
    }

    static char toChar(int idx) {
        if (idx < 26) {
            return (char) ('A' + idx);
        } else {
            return (char) ('a' + (idx - 26));
        }
    }
}