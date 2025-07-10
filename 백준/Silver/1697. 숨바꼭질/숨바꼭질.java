import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;
    static boolean[] visited = new boolean[MAX];
    static int[] time = new int[MAX];

    public static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == target) {
                System.out.println(time[now]);
                return;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    time[next] = time[now] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        bfs(N, K);
    }
}