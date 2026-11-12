import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static ArrayList<int[]> list;
    static int[] visited;

    static long totalX, totalY;
    static long min;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            list = new ArrayList<>();
            visited = new int[N / 2];

            // 테스트 케이스마다 초기화
            totalX = 0;
            totalY = 0;
            min = Long.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new int[] {x, y});

                // 모든 지렁이의 좌표 합
                totalX += x;
                totalY += y;
            }

            // 움직일 지렁이 N / 2마리를 선택
            dfs(0, 0);

            sb.append("#").append(tc).append(" ")
              .append(min).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int depth, int start) {
        // 움직일 지렁이를 N / 2마리 선택한 경우
        if (depth == N / 2) {
            long selectedX = 0;
            long selectedY = 0;

            // 선택된 지렁이들의 좌표 합
            for (int index : visited) {
                selectedX += list.get(index)[0];
                selectedY += list.get(index)[1];
            }

            // 벡터 합 = 도착점 좌표 합 - 출발점 좌표 합
            // 도착점 좌표 합 = 전체 좌표 합 - 출발점 좌표 합
            long vx = totalX - 2 * selectedX;
            long vy = totalY - 2 * selectedY;

            // 문제에서 정의한 벡터의 크기
            long size = vx * vx + vy * vy;

            min = Math.min(min, size);
            return;
        }

        // 같은 지렁이를 다시 고르지 않도록 i + 1부터 탐색
        for (int i = start; i < N; i++) {
            visited[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}