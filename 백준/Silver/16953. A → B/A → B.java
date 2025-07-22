import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MAX_VALUE;
    static int N, M;

    public static void dfs(long n, int cnt) {
        if (n == M) {
            max = Math.min(cnt, max);
            return;
        }
        if (n > M) {
            return;
        }

        dfs(n * 2, cnt + 1);
        dfs(n * 10 + 1, cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(N, 1);

        if (max == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(max);
        }
    }
}