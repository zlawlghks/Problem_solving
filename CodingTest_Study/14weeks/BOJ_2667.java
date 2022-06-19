package Problem.ps_sutdy_14weeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2667 {

    static int N;
    static int[][] map;
    static int count;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static ArrayList<Integer> result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        count = 0;
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    search(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int c : result) {
            System.out.println(c);
        }
    }

    public static int search(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (checkRange(ny, nx)) {
                search(ny, nx);
                count++;
            }
        }
        return count;
    }


    public static boolean checkRange(int y, int x) {
        if (0 <= y && y < N && 0 <= x && x < N && map[y][x] == 1 && !visited[y][x]) {
            return true;
        }
        return false;
    }
}
