import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean found = false;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr[input.charAt(0) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                System.out.print((char) (i + 'a'));
                found = true;
            }
        }
        if (!found) {
            System.out.println("PREDAJA");
        }
    }
}