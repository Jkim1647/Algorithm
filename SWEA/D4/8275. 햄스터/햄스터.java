import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, X, M;

    static int[][] condition;
    static int[] visited;
    static int[] answer;

    static int maxSum;

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            condition = new int[M][3];
            visited = new int[N];
            answer = new int[N];

            maxSum = -1;

            for (int i = 0; i < M; i++) {

                st = new StringTokenizer(br.readLine());

                condition[i][0] = Integer.parseInt(st.nextToken()) - 1;
                condition[i][1] = Integer.parseInt(st.nextToken()) - 1;
                condition[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            sb.append("#")
              .append(test_case)
              .append(" ");

            if (maxSum == -1) {

                sb.append("-1");

            } else {

                for (int i = 0; i < N; i++) {
                    sb.append(answer[i]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth) {

        if (depth == N) {

            check();

            return;
        }

        for (int i = 0; i <= X; i++) {

            visited[depth] = i;

            dfs(depth + 1);
        }
    }

    static void check() {

        // 1. 모든 조건 확인
        for (int i = 0; i < M; i++) {

            int start = condition[i][0];
            int end = condition[i][1];
            int target = condition[i][2];

            int sum = 0;

            for (int j = start; j <= end; j++) {
                sum += visited[j];
            }

            if (sum != target) {
                return;
            }
        }

        // 2. 전체 햄스터 수 계산
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += visited[i];
        }

        // 3. 더 많은 햄스터를 배치한 경우 갱신
        if (total > maxSum) {

            maxSum = total;

            for (int i = 0; i < N; i++) {
                answer[i] = visited[i];
            }

        }
        // 4. 총합이 같으면 사전순 비교
        else if (total == maxSum) {

            for (int i = 0; i < N; i++) {

                if (visited[i] < answer[i]) {

                    for (int j = 0; j < N; j++) {
                        answer[j] = visited[j];
                    }

                    break;

                } else if (visited[i] > answer[i]) {

                    break;
                }
            }
        }
    }
}