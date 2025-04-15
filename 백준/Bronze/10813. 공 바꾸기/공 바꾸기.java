import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = i + 1;
        }
        for (int n = 0; n < b; n++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = arr[i - 1];
            arr[i - 1] = arr[j - 1];
            arr[j - 1] = k;
        }
        // 2 1 3 4 5 // 2 1 4 3 5 // 3 1 4 2 5 // 3 1 4 2 5

        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}

