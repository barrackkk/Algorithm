import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int N, dpcnt, cnt;

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    public static int fibdp(int n) {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dpcnt++;
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        fibdp(N);
        fib(N);
        System.out.println(cnt + " " + dpcnt);
    }
}