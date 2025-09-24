import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int[] chickenPick;
    static int N, M, ans = Integer.MAX_VALUE;

    public static void comb(int cnt, int chickenIdx) {
        if (cnt == M) {
            int sum = 0;

            for (int[] h : home) {
                int best = Integer.MAX_VALUE;
                for (int i : chickenPick) {
                    int[] c = chicken.get(i);
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    best = Math.min(best, d);
                }
                sum += best;

                if (sum >= ans) {
                    break;
                }
            }

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = chickenIdx; i < chicken.size(); i++) {
            chickenPick[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        chickenPick = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 1) {
                    home.add(new int[]{i, j});
                } else if (num == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0);
        sb.append(ans);
        System.out.println(sb);
    }
}