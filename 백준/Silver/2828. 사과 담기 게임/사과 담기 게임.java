import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt, M, K, areaCnt;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int cnt = 0;
        int left = 1;
        int right = M;

        for (int i = 0; i < J; i++) {
            int idx = Integer.parseInt(br.readLine());

            if (idx < left) {
                int d = left - idx;
                cnt += d;
                left -= d;
                right -= d;
            }
            if (idx > right) {
                int d = idx - right;
                cnt += d;
                left += d;
                right += d;
            }
        }
        sb.append(cnt);
        System.out.println(sb);

    }
}