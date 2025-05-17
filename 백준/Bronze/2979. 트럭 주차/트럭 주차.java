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
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[100];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            for (int j = n1; j < n2; j++) {
                arr[j]++;
            }

        }
        for (int i1 : arr) {
            switch (i1) {
                case 1:
                    sum += a;
                    break;
                case 2:
                    sum += b * 2;
                    break;
                case 3:
                    sum += c * 3;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sum);
    }
}