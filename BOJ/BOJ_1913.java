package Problem.PS_22_06_06;
// 달팽이
// 구현 방법은 값이 입력되는 방향을 역순으로 생각하여 구현

import java.util.Scanner;

public class BOJ_1913 {

    // 좌표 설정 상 좌 우 하 순서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int map[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        map = new int[N][N];
        
        buildMap(N);


        int y = 0, x = 0; // k값의 x, y좌표
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sb.append(map[i][j]).append(" ");
                if (map[i][j] == k) {
                    x = i;
                    y = j;
                }
            }
            sb.append("\n");
        }
        sb.append(x + 1).append(" ").append(y + 1);
        System.out.println(sb);

    }


    public static void buildMap(int N) {
        int y = 0, x = 0, ny = 0, nx = 0, dir = 2;
        int value = N * N;

        map[0][0] = value;
        value -= 1;

        while (true) {
            if (value == 0){
                break;
            }

            ny = y + dy[dir];
            nx = x + dx[dir];

            if ((0 <= ny && ny < N) && (0 <= nx && nx < N) && (map[ny][nx] == 0)) {
                map[ny][nx] = value;
                value -= 1;
                y = ny;
                x = nx;
            } else {
                dir = (dir + 4 - 1) % 4;
            }
        }
    }
}





