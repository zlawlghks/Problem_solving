package Problem.ps_sutdy_14weeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
// bfs, 4방향 좌표, 좌표 가중치
public class BOJ_2178 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            for (int i = 0; i < dy.length; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (checkPoint(nextY, nextX)) {
                    queue.add(new int[]{nextY, nextX});
                    map[nextY][nextX] = map[nowY][nowX] + 1; // 가중치 설정
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static boolean checkPoint(int y, int x) {
        if (y < 0 || x < 00 || y >= n || x >= m) {
            return false;
        }
        if (visited[y][x] == true || map[y][x] == 0) {
            return false;
        }
        return true;
    }
}
