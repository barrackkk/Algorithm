import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(), cnt++));
        }

        Collections.sort(list, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getCnt() - e2.getCnt();
            } else {
                return e1.getAge() - e2.getAge();
            }
        });
        for (Member member : list) {
            System.out.println(member.getAge() + " " + member.getName());
        }

    }


    static class Member {
        int age;
        String name;
        int cnt;

        public Member(int age, String name, int cnt) {
            this.age = age;
            this.name = name;
            this.cnt = cnt;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getCnt() {
            return cnt;
        }
    }

}