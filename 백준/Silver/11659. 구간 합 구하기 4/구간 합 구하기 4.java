import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int[] arr = new int[i + 1];
        int[] pSum = new int[i + 1];

        st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= i; k++) {
            arr[k] = Integer.parseInt(st.nextToken());
            pSum[k] = pSum[k - 1] + arr[k];
        }

        for (int z = 0; z < j; z++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int sum = pSum[right] - pSum[left - 1];
            System.out.println(sum);

        }


    }
}