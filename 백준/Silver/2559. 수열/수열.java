import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }

        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += arr.get(i);
        }

        int max = sum;
        for (int i = b; i < a; i++) {
            sum = sum - arr.get(i - b) + arr.get(i);
            max = Integer.max(max, sum);
        }

        System.out.println(max);
    }
}