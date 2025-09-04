import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int count = 0;
        int num = 666;
        while (true) {

            if (String.valueOf(num).contains("666")) {
                count++;
                if (count == N) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}