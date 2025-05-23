import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] str = new String[N];
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                str[i] = st.nextToken();
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            System.out.println("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    System.out.print(str[i]);
                    cnt++;
                    if (cnt % 10 == 0) {
                        System.out.println();
                    }
                }

            }
            System.out.println();

        }
    }
}
