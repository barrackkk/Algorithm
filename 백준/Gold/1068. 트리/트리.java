import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, root, deletedNode;
    static List<List<Integer>> list = new ArrayList<>();

    static int dfs(int cur) {
        if (cur == deletedNode) {
            return 0;
        }

        int leaf = 0;
        int validChild = 0;

        for (int child : list.get(cur)) {
            if (child == deletedNode) {
                continue;
            }
            validChild++;
            leaf += dfs(child);
        }

        if (validChild == 0) {
            return 1;
        }
        return leaf;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) {
                root = i;
            } else {
                list.get(num).add(i);
            }
        }

        deletedNode = Integer.parseInt(br.readLine());

        if (deletedNode == root) {
            sb.append("0");
            System.out.println(sb);
            return;
        }

        sb.append(dfs(root));
        System.out.println(sb);
    }
}