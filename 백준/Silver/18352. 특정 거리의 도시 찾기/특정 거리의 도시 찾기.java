import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        bfs(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                bw.write(i + "\n");
                found = true;
            }
        }

        if (!found) {
            bw.write("-1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}