import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }
        int a = 0;
        int b = 0;
        Arrays.sort(arr);
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        arr[a] = Integer.MAX_VALUE;
        arr[b] = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 0; i < 7; i++) {
            System.out.println(arr[i]);
        }
    }


}