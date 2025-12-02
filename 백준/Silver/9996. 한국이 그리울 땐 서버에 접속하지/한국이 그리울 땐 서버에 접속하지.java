import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] line = pattern.split("\\*");

        String first = line[0];
        String last = line[1];

        int n1 = first.length();
        int n2 = last.length();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() < n1 + n2) {
                sb.append("NE\n");
                continue;
            }

            boolean tf = true;

            for (int j = 0; j < n1; j++) {
                if (input.charAt(j) != first.charAt(j)) {
                    tf = false;
                    break;
                }
            }

            if (tf) {
                for (int j = 0; j < n2; j++) {
                    if (input.charAt(input.length() - n2 + j) != last.charAt(j)) {
                        tf = false;
                        break;
                    }
                }
            }

            if (tf) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        System.out.print(sb);
    }
}