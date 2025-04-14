import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int c;
        for(int i = 0 ; i < a ; i++){
            int sum = 0;
            sum = i;
            c = i;
            while(c > 0){
                sum += c % 10;
                c /= 10;
            }
            if (sum == a) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
}

