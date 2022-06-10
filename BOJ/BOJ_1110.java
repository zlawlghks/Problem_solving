package Problem.ps_study_13week;
// 더하기 싸이클

import java.util.Scanner;

public class BOJ_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmp = 0, ten, one, res = 0, cnt = 0;
        int N = sc.nextInt();
        tmp = N;

        while ( true ) {
            if (tmp < 10) {
                ten = 0;
            } else {
                ten = tmp / 10;
            }

            one = tmp % 10;

            res = ten + one;
            cnt++;

            ten = tmp % 10;
            one = res % 10;
            tmp = (ten * 10) + one;

            if (tmp == N)
                break;
        }
        System.out.println(cnt);
    }
}
