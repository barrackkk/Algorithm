import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fireTime;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void fire(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0];
            int y = c[1];
            int t = c[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (map[nx][ny] == '#') {
                    continue;
                }
                if (fireTime[nx][ny] <= t + 1) {
                    continue;
                }
                fireTime[nx][ny] = t + 1;
                q.offer(new int[]{nx, ny, t + 1});
            }
        }
    }

    public static String bfsJ(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy, 0}); 

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    return String.valueOf(t + 1);
                }
                if (map[nx][ny] == '#') {
                    continue;             
                }
                if (visited[nx][ny]) {
                    continue;
                }

                if (fireTime[nx][ny] <= t + 1) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, t + 1});
            }
        }
        return "IMPOSSIBLE";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireTime = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], 10000);
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
            }
        }

        Queue<int[]> pq = new ArrayDeque<>();
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    pq.offer(new int[]{i, j, 0});
                }
                if (map[i][j] == 'J') {
                    sx = i;
                    sy = j;
                }
            }
        }

        fire(pq);

        System.out.println(bfsJ(sx, sy));
    }
}