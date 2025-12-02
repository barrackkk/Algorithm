import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = br.readLine();
        int a = input.length() - 1;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) == input.charAt(a)) {
                a--;
            } else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);

    }
}