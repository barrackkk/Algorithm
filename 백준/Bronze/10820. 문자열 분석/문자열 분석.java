import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int lower = 0; 
            int upper = 0; 
            int number = 0;
            int space = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c >= 'a' && c <= 'z') lower++;
                else if (c >= 'A' && c <= 'Z') upper++;
                else if (c >= '0' && c <= '9') number++;
                else if (c == ' ') space++;
            }

            System.out.printf("%d %d %d %d%n", lower, upper, number, space);
        }
    }
}