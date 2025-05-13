import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean isThat = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] stack = new int[size];

            for (int j = 0; j < size; j++) {
                stack[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < size - 1; j++) {
                if (stack[j] < stack[j + 1]) {
                    isThat = false;
                    break;
                }
            }

            if (!isThat) break;
        }

        System.out.println(isThat ? "Yes" : "No");
    }
}