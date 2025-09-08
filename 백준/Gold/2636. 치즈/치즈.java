import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<int[]> melt;


    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                    visited[nx][ny] = true;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    melt.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCnt = 0;
        while (true) {
            visited = new boolean[N][M];
            melt = new ArrayList<>();

            dfs(0, 0);
            if (melt.isEmpty()) {
                break;
            }
            lastCnt = melt.size();

            for (int[] ints : melt) {
                map[ints[0]][ints[1]] = 0;
            }
            time++;
        }
        System.out.println(time);
        System.out.println(lastCnt);
    }
}