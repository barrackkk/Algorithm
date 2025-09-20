import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickenShops = new ArrayList<>();
    static int[] pick;                 // ★ 여기선 선언만
    static int answer = Integer.MAX_VALUE;

    static void comb(int cnt, int chickenIdx) {
        if (cnt == M) {
            int sum = 0;
            for (int[] h : homes) {
                int best = Integer.MAX_VALUE;
                for (int idx : pick) {
                    int[] s = chickenShops.get(idx);
                    int d = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    best = Math.min(best, d);
                }
                sum += best;
                if (sum >= answer) {
                    break;
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = chickenIdx; i < chickenShops.size(); i++) {
            pick[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    homes.add(new int[]{i, j});
                } else if (arr[i][j] == 2) {
                    chickenShops.add(new int[]{i, j});
                }
            }
        }

        pick = new int[M];

        comb(0, 0);
        System.out.println(answer);
    }
}