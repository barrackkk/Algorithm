import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        if (a >= 90 && a <= 100) {
            System.out.println("A");
        }
        if (a >= 80 && a <= 89) {
            System.out.println("B");
        }
        if (a >= 70 && a <= 79) {
            System.out.println("C");
        }
        if (a >= 60 && a <= 69) {
            System.out.println("D");
        } else if (a <= 59) {
            System.out.println("F");
        }
    }
}
