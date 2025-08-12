import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int cnt = 0;
        int limit = 0;

        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            if (cnt == 0) {
                limit = cur;
            }
            cnt++;

            if (cnt == limit) {
                cnt = 0;
                answer++;
            }
        }
        if (cnt != 0) {
            answer++;
        }
        System.out.println(answer);
    }
}