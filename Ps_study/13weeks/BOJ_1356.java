package Problem.ps_study_13주차;
// 유진수

import java.util.Scanner;

public class BOJ_1356 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        if (testNumber(N)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean testNumber(String N) {
        int lenN = N.length();
        int leftNumber, rightNumber;
        if (lenN == 1) {
            return false;
        } else {
            for (int i = 0; i < lenN - 1; i++) {
                leftNumber = 1;
                rightNumber = 1;
                for (int j = 0; j <= i; j++) {
                    leftNumber *= N.charAt(j) - '0';
                }
                for (int j = i+1; j < lenN; j++) {
                    rightNumber *= N.charAt(j) - '0';
                }
                if (leftNumber == rightNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}
