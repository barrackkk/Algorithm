import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 우, 좌
    static int[] dy = {0, 0, 1, -1};

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    count += dfs(nx, ny); // 연결된 집 수 누적
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int pcnt = dfs(i, j);
                    result.add(pcnt);
                    cnt++;
                }
            }
        }

        Collections.sort(result);
        System.out.println(cnt);
        for (int num : result) {
            System.out.println(num);
        }
    }
}