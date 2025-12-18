import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, cnt, M, K, areaCnt;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void go(int x1, int y1, int x2, int y2) {
        int first = map[x1][y1];
        boolean unique = true;

        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                if (first != map[x][y]) {
                    unique = false;
                    break;
                }
            }
            if (!unique) {
                break;
            }
        }

        if (unique) {
            sb.append(first);
            return;
        }
        sb.append("(");

        int mx = (x1 + x2) / 2;
        int my = (y1 + y2) / 2;
        go(x1, y1, mx, my);
        go(x1, my, mx, y2);
        go(mx, y1, x2, my);
        go(mx, my, x2, y2);

        sb.append(")");
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                map[i][j] = c - '0';
            }
        }
        go(0, 0, N, N);

        System.out.println(sb);
    }
}