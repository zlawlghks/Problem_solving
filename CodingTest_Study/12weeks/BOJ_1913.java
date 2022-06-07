package Problem.ps_study_12주차;
// 달팽이

import java.util.Scanner;

public class BOJ_1913 {

    // 일차원 배열인 dy, dx 방향 변수 설정 (상, 우, 하, 좌)
    static int[] dy = {-1, 0, 1, 0}; // 행
    static int[] dx = {0, 1, 0, -1}; // 열
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int targetValue = sc.nextInt();

        map = new int[N][N];

        buildMap(N);


        // 출력값이 많은 문제이므로 StringBuilder 를 사용하여 메모리를 최소한으로 사용한다.
        StringBuilder sb = new StringBuilder();
        int targetY = 0, targetX = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sb.append(map[i][j]).append(" ");
                if (map[i][j] == targetValue) {
                    targetY = i + 1;
                    targetX = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(targetY).append(" ").append(targetX);
        System.out.println(sb);
    }

    public static void buildMap(int N) {
        int newY, newX, y = 0, x = 0;
        // 방향 변수의 기본 설정은 상 우 하 좌 순서이기 때문에
        // 역순인 하 방향으로 설정을 해줘야 한다.
        // 그래서 방향 변수 dy, dx 일차원 배열의 세번째 값, 즉 인덱스 값인 2를 설정했다.
        int dir = 2; // 역순(하)으로 진행
        int value = N * N;

        map[0][0] = value;
        value--;

        while (value > 0) {
            // newY, newX에 새로운 배열의 좌표값 할당
            newY = y + dy[dir];
            newX = x + dx[dir];

            // newY, newX의 값이 배열의 범위를 넘지 않을 경우, 이미 지난 배열이 아닐 경우
            if ((0 <= newY) && (newY < N) && (0 <= newX) && (newX < N) && (map[newY][newX] == 0)) {
                map[newY][newX] = value;
                value--;
                // y, x에 좌표값을 업데이트
                y = newY;
                x = newX;
            } else { // 좌표가 배열의 범위에 닿았을때 또는 중복값이 있을때 배열의 진행 방향을 바꿔줘야 한다.
                dir = (dir + 4 - 1) % 4;
            }
        }
    }
}
