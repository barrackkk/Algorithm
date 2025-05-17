import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0' - 49;
            arr[a]++;
        }

        for (int i : arr) {
            System.out.printf(i + " ");

        }
    }
}