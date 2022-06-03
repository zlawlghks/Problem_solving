package Problem.Basic;
// 사분면 고르기 (B4)

import java.util.Scanner;

public class BOJ_14681 {
    public static void main(String[] args) {
        int []array = new int[4];
        int x = 0, y = 0;
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();

        if (x > 0) {
            if (y > 0) {
                System.out.println("1");
            } else {
                System.out.println("4");
            }
        } else {
            if (y > 0) {
                System.out.println("2");
            } else {
                System.out.println("3");
            }
        }
    }
}
