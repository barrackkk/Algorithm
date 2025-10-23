import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][1];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i][0] = number;

        }
        int max = Integer.MIN_VALUE;
        int maxCnt = 0;
        int cnt = 0;
        int idx = 0;
        while (true) {
            for (int i = 0; i < N; i++) {
                if (max < arr[i][0]) {
                    max = arr[i][0];
                    idx = i;
                    maxCnt = 1;
                } else if (max == arr[i][0]) {
                    maxCnt++;
                    idx = i;
                }
            }

            if (max == arr[0][0] && maxCnt == 1) {
                System.out.println(cnt);
                return;
            } else {
                arr[idx][0]--;
                arr[0][0]++;
                max = arr[idx][0];
                cnt++;
            }
        }
    }
}