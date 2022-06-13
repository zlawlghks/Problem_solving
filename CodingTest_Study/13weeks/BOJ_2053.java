package Problem.ps_study_13week;
// 숫자 야구

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_2053 {

    static int N;

    static List<BaseBallData> inputData = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int strikeNum = Integer.parseInt(st.nextToken());
            int ballNum = Integer.parseInt(st.nextToken());

            BaseBallData baseBallData = new BaseBallData(number, strikeNum, ballNum);
            inputData.add(baseBallData);
        }

        check();
    }

    public static void check() {
        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            if (duplicateCheckNum(i)) continue;
            int allTestPass = 0;

            for (int j = 0; j < N; j++) {
                int checkStrikeNum = 0, checkBallNum = 0;

                BaseBallData num = inputData.get(j);
                String number = Integer.toString(num.number);
                String checkNum = Integer.toString(i);

                for (int k = 0; k < 3; k++) {
                    if (number.charAt(k) == checkNum.charAt(k)){
                        checkStrikeNum++;
                    }
                }

                for (int h = 0; h < 3; h++) {
                    for (int u = 0; u < 3; u++) {
                        if(number.charAt(h) == checkNum.charAt(u)){
                            if (h != u){
                                checkBallNum++;
                            }
                        }
                    }
                }
                if ((num.strike == checkStrikeNum) && (num.ball == checkBallNum)) {
                    allTestPass++;
                }
            }
            if (allTestPass == N) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean duplicateCheckNum(int num) {
        String checkNum = Integer.toString(num);
        boolean result = false;
        if (checkNum.charAt(0) == checkNum.charAt(1) || checkNum.charAt(0) == checkNum.charAt(2) || checkNum.charAt(1) == checkNum.charAt(2)){
            result = true;
        }

        if (checkNum.charAt(0) == '0' || checkNum.charAt(1) == '0' || checkNum.charAt(2) == '0') {
            result = true;
        }
        return result;
    }

    public static class BaseBallData {
        int number;
        int strike;
        int ball;

        public BaseBallData(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
