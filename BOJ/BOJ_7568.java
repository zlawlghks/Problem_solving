package Problem.Basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 덩치
public class BOJ_7568 {
    public static void main(String[] args) {

        /*int N = 0;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[][] member = new int[N][2];
        int[][] sortedMember = new int[N][2];

        int[] rank = new int[N];

        // rank 배열 0으로 초기화
        for (int i = 0; i < N; i++) {
            rank[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 1; j++) {
                member[i][j] = sc.nextInt();
                sortedMember[i][j] = member[i][j];
            }
        }

        Arrays.sort(sortedMember, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        // 출력값 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 1; j++) {
                System.out.print(sortedMember[i][j] + " ");
            }
            System.out.println();
        }
*/
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] member = new int[N][2];

        for (int i = 0; i < N; i++) {
            member[i][0] = sc.nextInt();
            member[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (member[i][0] < member[j][0] && member[i][1] < member[j][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
