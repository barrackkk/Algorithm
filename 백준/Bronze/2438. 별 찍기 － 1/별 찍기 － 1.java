import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <  a; i++){
            for(int j = 0 ; j <= i  ; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
