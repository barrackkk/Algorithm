import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static void dfs(int x, int y, int[][] board) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (board[nx][ny] == 0) {
                    board[nx][ny] = 2;
                    dfs(nx, ny, board);
                }
            }
        }
    }

    static int simulate() {
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, board[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2) {
                    dfs(i, j, board);
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    safe++;
                }
            }
        }
        return safe;
    }


    public static void buildWalls(int cnt, int start) {
        if (cnt == 3) {
            result = Math.max(result, simulate());
            return;
        }

        int idx = N * M;
        for (int i = start; i < idx; i++) {
            int x = i / M;
            int y = i % M;

            if (map[x][y] != 0) {
                continue;
            }

            map[x][y] = 1;
            buildWalls(cnt + 1, i + 1);
            map[x][y] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWalls(0, 0);
        System.out.println(result);
    }
}