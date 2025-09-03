import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int fac(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * fac(num - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int cnt5 = 0;
            for (int i = 5; i <= N; i *= 5) {
                cnt5 += N / i;
            }

            System.out.println(cnt5);
        }

    }
}