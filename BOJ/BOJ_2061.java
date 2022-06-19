package Problem.ps_sutdy_14weeks;
// 좋은 암호


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2061 {

    static BigInteger k, l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = new BigInteger(st.nextToken());
        l = new BigInteger(st.nextToken());
        test();
    }

    static void test() {
        for (int i = 2; i < l.intValue(); i++) {
            if ((k.remainder(BigInteger.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
                System.out.print("BAD " + i);
                return;
            }
        }
        System.out.print("GOOD");
    }
}
