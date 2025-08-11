import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int t = 0; t < N; t++) {
            String str = br.readLine();
            
            char prev = str.charAt(0);
            boolean[] visit = new boolean[26];
            boolean tf = true;
            
            visit[prev - 'a'] = true;
            
            for (int i = 1; i < str.length(); i++) {
                char cur = str.charAt(i);
                if (cur == prev) {
                    continue;
                }
                if (visit[cur - 'a']) {
                    tf = false;
                    break;
                }
                visit[cur - 'a'] = true;
                prev = cur;

            }
            if (tf) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}