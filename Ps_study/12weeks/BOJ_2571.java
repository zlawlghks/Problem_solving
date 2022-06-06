package Problem.ps_study_12주차;
// 색종이-3

import java.util.Scanner;

public class BOJ_2571 {
    final static int SIZE = 100;
    static int[][] map;
    static int maxArea = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        map = new int[SIZE][SIZE];

        for (int n = 0; n < N; n++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 검은색 색종이의 좌표를 a, b로 입력
            // 이차원 배열인 map의 a, b 좌표에 값을 0이 아니게 값을 변경함
            // 검은색 색종이가 붙어있다는걸 확인하기 위해서
            for (int x = a; x < (a + 10); x++) {
                for (int y = b; y < (b + 10); y++) {
                    map[x][y]++;
                }
            }
        }


        // 브루트포스(완전탐색)
        // 4중포문을 이용하여 하나하나의 값들을 모두 탐색함
        // startX, startY (직사각형 좌하단 좌표)
        // endX, endY (직사각형의 우상단 좌표)
        for (int startX = 0; startX < SIZE - 1; startX++) {
            for (int startY = 0; startY < SIZE - 1; startY++) {
                if (map[startX][startY] == 0) continue; // 검은색 색종이가 붙지 않음
                for (int endX = startX + 1; endX < SIZE; endX++) {
                    for (int endY = startY + 1; endY < SIZE; endY++) {
                        if (map[endX][endY] == 0) break; // 검은색 색종이가 붙지 않음

                        int area = (endX - startX + 1) * (endY - startY + 1);

                        if (area <= maxArea) continue;
                        if (check(startX, startY, endX, endY))
                            maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    // 문제에서 '직사각형'의 검은색 색종이를 잘라내기 때문에
    // 0의 값을 포함한 좌표가 있다면 검은색 색종이가 붙지 않은 좌표이기에
    // false 를 반환, 0이 없다면 완벽하게 검은색 색종이를 자른 것이기에 true 반환
    static boolean check(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++)
            for (int y = startY; y <= endY; y++)
                if (map[x][y] == 0) return false;

        return true;
    }
}
