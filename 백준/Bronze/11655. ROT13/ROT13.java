import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                char c1 = (char) ((c - 'a' + 13) % 26 + 'a');
                sb.append(c1);
            } else if ('A' <= c && c <= 'Z') {
                char c1 = (char) ((c - 'A' + 13) % 26 + 'A');
                sb.append(c1);
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}