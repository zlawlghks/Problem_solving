package Problem.ps_study_13week;
// 색칠 1

/*
  종이를 x = f에 맞춰서 접는다. 이때, 왼쪽 종이가 오른쪽 종이 위에 올라오게 접는다.
  종이를 가로로 c+1개의 크기가 동일 한 구간으로 나눈다. 그 다음에 c번 가장 위의 구간부터 차례대로 접는다.
  왼쪽 아래가 (x1, y1) 이고, 오른쪽 위가 (x2, y2)인 직사각형을 찾는다.
  이때, (0, 0)은 현재 접힌 상태에서 가장 왼쪽 아래 점이다.
  그 직사각형을 칠한다. 이때, 페인트는 겹쳐있는 모든 곳에 스며든다. 종이를 편다.
*/

// W, H, f, c, x1, y1, x2, y2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class BOJ_1117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long W = Integer.parseInt(st.nextToken());
        long H = Integer.parseInt(st.nextToken());
        long f = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());

        long area = (x2 - x1) * (y2 - y1) * (c+1);
        if (f <= W / 2) { // 왼쪽 크기 <= 오른쪽 크기
            if (f <= x1) { // 왼쪽 영향 X
                System.out.println((W * H) - area);
            } else { // 왼쪽 영향 받음
                System.out.println((W * H) - (area + (min(f, x2) - x1) * (y2 - y1) * (c + 1)));
            }
        } else { // 왼쪽 크기 > 오른쪽 크기
            if (W <= x1 + f) { // 오른쪽 영향 X
                System.out.println((W * H) - area);
            } else { // 오른쪽 영향 받음
                System.out.println((W * H) - (area + (min(W, f + x2) - (f + x1)) * (y2 - y1) * (c+1)));
            }
        }
    }
}

