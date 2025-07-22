import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0]; // 끝자리가 0이면 오르막 X
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % 10007;
        }

        System.out.println(result);
    }
}