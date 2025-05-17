import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] a = s.split("\\*");

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();

            boolean tf = true;

            if (s1.length() < a[0].length() + a[1].length()) {
                tf = false;
            } else {
                for (int j = 0; j < a[0].length(); j++) {
                    if (s1.charAt(j) != a[0].charAt(j)) {
                        tf = false;
                        break;
                    }
                }

                for (int k = 0; k < a[1].length(); k++) {
                    int idx = s1.length() - a[1].length() + k;
                    if (s1.charAt(idx) != a[1].charAt(k)) {
                        tf = false;
                        break;
                    }
                }
            }

            if (tf) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}