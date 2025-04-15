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

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = d;
            int y = c;
            for (int j = 0; j < (d - c + 1) / 2; j++) {
                int k = arr[y - 1];
                arr[y - 1] = arr[z - 1];
                arr[z - 1] = k;
                z--;
                y++;
            }
        }
        for (int i : arr) {
            System.out.printf(i + " ");
        }

    }
}

