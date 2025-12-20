import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            Stack<Character> stk = new Stack<>();

            if (line.equals("end")) {
                System.out.println(sb);
                return;
            }

            Boolean mo = false;
            Boolean determine = false;
            int moCnt = 0;
            int jaCnt = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c != 'e' && c != 'o') {
                    if (!stk.isEmpty() && stk.peek() == c) {
                        determine = true;
                        break;
                    }
                }

                stk.push(c);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    mo = true;
                    moCnt++;
                    jaCnt = 0;
                } else {
                    moCnt = 0;
                    jaCnt++;
                }

                if (moCnt == 3 || jaCnt == 3) {
                    determine = true;
                    break;
                }
            }

            if (determine || !mo) {
                sb.append("<" + line + ">" + " is not acceptable.\n");
            }

            if (!determine && mo) {
                sb.append("<" + line + ">" + " is acceptable.\n");
            }
        }
    }
}