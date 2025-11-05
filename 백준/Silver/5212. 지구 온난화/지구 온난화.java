import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static char[][] next;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        next = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            next[i] = map[i].clone();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    int sea = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                            sea++;
                        } else if (map[nx][ny] == '.') {
                            sea++;
                        }
                    }
                    if (sea >= 3) {
                        next[i][j] = '.';
                    }
                }
            }
        }

        int minR = R, maxR = 0, minC = C, maxC = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (next[i][j] == 'X') {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (minR > maxR || minC > maxC) {
            System.out.println("X");
            return;
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                sb.append(next[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}