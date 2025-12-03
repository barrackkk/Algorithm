import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        int[] cnt = new int[200];

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            cnt[c]++;
        }

        int flag = 0;
        char mid = 0;
        for (int i = 'Z'; i >= 'A'; i--) {
            if (cnt[i] > 0) {
                if (cnt[i] % 2 == 1) {
                    mid = (char) i;
                    flag++;
                    cnt[i]--;
                }
                if (flag == 2) {
                    break;
                }

                for (int j = 0; j < cnt[i]; j += 2) {
                    result.insert(0, (char) i);
                    result.append((char) i);
                }
            }
        }

        if (mid != 0) {
            result.insert(result.length() / 2, mid);
        }

        if (flag == 2) {
            sb.append("I'm Sorry Hansoo");
        } else {
            sb.append(result);
        }
        System.out.println(sb);


    }
}