package Problem.ps_sutdy_14weeks;
// 5학년은 다니기 싫어요


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 총 n 학기 ,전공학점: a, 총 학점: b
// 졸업 조건 총 130학점 이상, 그 중 66학점 이상은 전공학점
// 10개의 학기 전공과목 x개, 비전공과목 y개
// 한 학기 전공, 비전공 수업 포함 최대 6과목
// 한 과목 수강하면 3학점, 최대 18학점 이수
public class BOJ_23028 {

    static int n, a, b;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[10][2];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st1.nextToken());
            arr[i][1] = Integer.parseInt(st1.nextToken());
        }

        check();
    }

    public static void check() {
        int saveA = a, saveB = b;
        for (int i = 0; i < 8 - n; i++) {
            for (int j = 0; j < arr[i][0]; j++) {
                if (saveA >= 66) break;
                saveA += 3;
                saveB += 3;
            }
            for (int j = 0; j < arr[i][1]; j++) {
                if (saveA >= 66 && saveB >= 130) {
                    System.out.println("Nice");
                    return;
                }
                saveB += 3;
            }
        }

        System.out.println("Nae ga wae");
    }
}
