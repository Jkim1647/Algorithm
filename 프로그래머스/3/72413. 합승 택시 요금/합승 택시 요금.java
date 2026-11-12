import java.util.*;

class Solution {

    static ArrayList<int[]>[] graph;
    static final int INF = 0x3f3f3f3f;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];

            graph[u].add(new int[]{v, cost});
            graph[v].add(new int[]{u, cost});
        }

        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);

        int answer = INF;

        for(int i=1; i<=n; i++) {
            answer = Math.min(
                answer,
                distS[i] + distA[i] + distB[i]
            );
        }

        return answer;
    }

    static int[] dijkstra(int start, int n) {

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            int now = cur[0];
            int cost = cur[1];

            if(cost > dist[now]) continue;

            for(int[] edge : graph[now]) {

                int next = edge[0];
                int nextCost = edge[1];

                int newCost = cost + nextCost;

                if(dist[next] > newCost) {
                    dist[next] = newCost;
                    pq.add(new int[]{next, newCost});
                }
            }
        }

        return dist;
    }
}