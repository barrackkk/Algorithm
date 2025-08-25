import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static int dfs(int x, int y) {
        visited[x][y] = true;

        int area = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    area += dfs(nx, ny);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        int max = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[k][j] += 1;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (!visited[j][k] && map[j][k] == 0) {
                    result.add(dfs(j, k));
                }
            }
        }

        System.out.println(result.size());

        result.sort(Comparator.naturalOrder());
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

}
