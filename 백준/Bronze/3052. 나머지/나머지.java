import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[42];

        int cnt = 0;

        for (int n = 0; n < 10; n++) {
            int a = Integer.parseInt(br.readLine());
            int i = a % 42;
            arr[i] = 1;

        }

        for (int i : arr) {
            if (i == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}

