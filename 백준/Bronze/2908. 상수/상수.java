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

        int a1 = a / 100;
        int a2 = a % 100 / 10 ;
        int a3 = a % 100 % 10;
        a = a3*100 + a2*10 + a1;

        int b1 = b / 100;
        int b2 = b % 100 / 10 ;
        int b3 = b % 100 % 10;
        b = b3*100 + b2*10 + b1;

        if (a > b) {
            System.out.println(a);
        }
        else if (b > a) {
            System.out.println(b);
        }

    }
}
