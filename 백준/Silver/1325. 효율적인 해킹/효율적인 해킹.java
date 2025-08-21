import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    static int dfs(int cur) {
        visited[cur] = true;
        int cnt = 0;

        for (int nxt : graph[cur]) {
            if (!visited[nxt]) {
                cnt += 1 + dfs(nxt);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int[] reach = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int cnt = dfs(i);
            reach[i] = cnt;

            if (cnt > max) {
                max = cnt;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (reach[i] == max) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
}