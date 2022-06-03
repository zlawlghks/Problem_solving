package Problem.Basic;

import java.util.Scanner;

// 한수 (S4)
public class BOJ_1065 {
    public static void main(String[] args) {
        int N = 0, Han = 0; // Han은 한수
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        if (N < 100) {
            Han = N;
            System.out.println(Han);
        } else {
            int i = 100;
            Han = 99;
            int firstNum = 0, twoNum = 0, threeNum = 0; // 각각 첫째, 둘째, 셋째자리
            while (true) {
                firstNum = i / 100;
                twoNum = ((i % 100)) / 10;
                threeNum = ((i % 100)) % 10;
                if (twoNum - firstNum == threeNum - twoNum) {
                    Han++;
                }
                ++i;
                if(i > N) break;
            }
            System.out.println(Han);
        }
    }
}
