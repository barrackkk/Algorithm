import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp0 = new int[41];
    static int[] dp1 = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp0[0] = 1;
            dp0[1] = 0;

            dp1[0] = 0;
            dp1[1] = 1;
            for (int j = 2; j <= n; j++) {
                dp0[j] = dp0[j - 1] + dp0[j - 2];
                dp1[j] = dp1[j - 1] + dp1[j - 2];
            }
            System.out.println(dp0[n] + " " + dp1[n]);
        }

    }
}