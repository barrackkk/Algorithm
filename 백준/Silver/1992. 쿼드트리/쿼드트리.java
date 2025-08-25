import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    static void rec(int x1, int y1, int x2, int y2) {
        int first = map[x1][y1];
        boolean uniform = true;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (map[i][j] != first) {
                    uniform = false;
                    break;
                }
            }
            if (!uniform) {
                break;
            }
        }

        if (uniform) {
            sb.append(first);
            return;
        }

        sb.append('(');

        int mx = (x1 + x2) / 2;
        int my = (y1 + y2) / 2;
        rec(x1, y1, mx, my);
        rec(x1, my, mx, y2);
        rec(mx, y1, x2, my);
        rec(mx, my, x2, y2);

        sb.append(')');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        rec(0, 0, N, N);
        System.out.println(sb.toString());
    }
}