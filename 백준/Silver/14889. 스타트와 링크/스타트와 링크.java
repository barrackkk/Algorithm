import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] S;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void pickTeam(int idx, int depth) {
        if (depth == N / 2) {
            int start = 0, link = 0;

            for (int i = 0; i < N; i++) { 
                for (int j = i + 1; j < N; j++) { 
                    if (visited[i] && visited[j]) {
                        start += S[i][j] + S[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += S[i][j] + S[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pickTeam(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pickTeam(0, 0);
        System.out.println(min);
    }
}