import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int t = 0; t < N; t++) {
            String word = br.readLine();
            words[t] = word;
        }

        Arrays.sort(words, (e1, e2) -> {

            if (e1.length() != e2.length()) {
                return e1.length() - e2.length();
            }
            if (e1.length() == e2.length()) {
                int numE1 = 0;
                int numE2 = 0;
                for (int i = 0; i < e1.length(); i++) {
                    char c1 = e1.charAt(i);
                    char c2 = e2.charAt(i);
                    if (c1 >= '0' && c1 <= '9') {
                        numE1 += c1 - '0';
                    }
                    if (c2 >= '0' && c2 <= '9') {
                        numE2 += c2 - '0';
                    }
                }
                if (numE1 != numE2) {
                    return numE1 - numE2;
                }
            }
            return e1.compareTo(e2);
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}