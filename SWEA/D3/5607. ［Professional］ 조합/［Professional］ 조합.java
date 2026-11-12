import java.io.*;
import java.util.*;

public class Solution {

    static final long MOD = 1234567891L;
    static final int MAX = 1_000_000;

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long[] factorial = new long[MAX + 1];

    public static void main(String[] args) throws Exception {
        // factorial[i] = i!을 MOD로 나눈 나머지
        factorial[0] = 1;

        for (int i = 1; i <= MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 조합 공식의 분자: N!
            long numerator = factorial[N];

            // 조합 공식의 분모: R! * (N-R)!
            long denominator =
                    factorial[R] * factorial[N - R] % MOD;

            // 페르마의 소정리로 분모의 모듈러 역원을 구함
            long inverse = power(denominator, MOD - 2);

            long answer = numerator * inverse % MOD;

            sb.append("#").append(tc).append(" ")
              .append(answer).append("\n");
        }

        System.out.print(sb);
    }

    // base^exponent를 MOD로 나눈 나머지를 빠르게 구함
    static long power(long base, long exponent) {
        long result = 1;

        while (exponent > 0) {
            // 지수가 홀수라면 현재 base를 결과에 곱함
            if (exponent % 2 == 1) {
                result = result * base % MOD;
            }

            // 밑을 제곱하고 지수는 절반으로 줄임
            base = base * base % MOD;
            exponent /= 2;
        }

        return result;
    }
}