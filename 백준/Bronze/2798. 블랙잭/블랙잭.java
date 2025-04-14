import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int rel = 0;
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine() , " ");

        for(int i = 0 ; i < a ; i++){
            arr.add(Integer.parseInt(st.nextToken() ));
        }


        int sum = 0;
        for(int j = 0 ; j < a ; j++){
            for(int k = j + 1  ; k < a ; k ++){
                for(int z = k + 1; z < a ; z++){
                    sum = arr.get(j) + arr.get(k) + arr.get(z);
                    if(sum <= b)
                        rel = Math.max(sum , rel);
                }
            }
        }
        System.out.println(rel);
    }
}

