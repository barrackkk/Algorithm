import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] wall = new boolean[N - 1];
        Arrays.fill(wall, true);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x - 1; j < y - 1; j++) {
                wall[j] = false;
            }
        }

        int cnt = 1;
        for (int i = 0; i < N - 1; i++) {
            if (wall[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}