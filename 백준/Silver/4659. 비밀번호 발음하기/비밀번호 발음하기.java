import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            boolean hasaeiou = false;
            int aeioucnt = 0;
            int notaeioucnt = 0;
            boolean tf = true;

            char prev = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                boolean isVowel = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');

                if (isVowel) {
                    hasaeiou = true;
                    aeioucnt++;
                    notaeioucnt = 0;
                } else {
                    notaeioucnt++;
                    aeioucnt = 0;
                }

                if (aeioucnt == 3 || notaeioucnt == 3) {
                    tf = false;
                    break;
                }
                if (i > 0 && c == prev) {
                    if (!(prev == 'e' || prev == 'o')) {
                        tf = false;
                        break;
                    }
                }

                prev = c;
            }

            if (tf && hasaeiou) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
        }
    }
}