import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String fileName = br.readLine();
        int idx = fileName.indexOf("*");

        String first = fileName.substring(0, idx);
        String last = fileName.substring(idx + 1);

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.length() < first.length() + last.length()) {
                sb.append("NE\n");
                continue;
            }
            
            boolean tf = line.startsWith(first) && line.endsWith(last);
            if (tf) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        System.out.println(sb);

    }
}