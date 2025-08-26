import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int prev = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            prev = sum;
            sum += num;

            if (sum == 100) {
                System.out.println(100);
                return;
            }
            if (sum > 100) {
                if (100 - prev < sum - 100) {
                    System.out.println(prev);
                } else {
                    System.out.println(sum);
                }
                return;
            }

        }
        System.out.println(sum);
    }
}
