package Problem.ps_study_13week;
// 안전 영역

import java.util.Scanner;

public class BOJ_2468 {
    static int N; // 행의 개수
    static int[][] map; // 2차원 배열 지도
    static int[][] transMap; // 2차원 배열 변형 지도
    static int[] dy = {-1, 0, 1, 0}; // 행 상 우 하 좌
    static int[] dx = {0, 1, 0, -1}; // 열 상 우 하 좌
    static boolean[][] check; // 방문을 체크
    static int count; // 안전지역개수
    static int max; // 최댓값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        max = 1;

        for (int i = 1; i < 101; i++) {
            transMap = new int[N][N];

            count = 0;

            check = new boolean[N][N];

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (map[a][b] <= i) {
                        transMap[a][b] = 0;
                    } else {
                        transMap[a][b] = 1;
                    }
                }
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (transMap[a][b] == 1 && !check[a][b]) {
                        Search(a, b);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void Search(int y, int x) {
        check[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (transMap[ny][nx] == 1 && !check[ny][nx]) {
                    Search(ny, nx);
                }
            }

        }
    }

}
