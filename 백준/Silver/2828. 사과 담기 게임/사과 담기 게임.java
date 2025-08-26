import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, J;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;
        int cnt = 0;
        for (int i = 0; i < J; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num < left) {
                int d = left - num;
                cnt += d;
                left -= d;
                right -= d;
            } else if (num > right) {
                int d = num - right;
                cnt += d;
                left += d;
                right += d;
            }
        }
        System.out.println(cnt);

    }


}
