import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T,N;
	static int[][] map;
	static PriorityQueue<int[]> pq;
	static int result;
	static ArrayList<int[]>[] list;
	//static int[] dist;
	static boolean[] visited;
	/*
	 프림? 다익스트라? DFS-백트래킹? 크루스칼?
	 
	 */
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			N += 2;
			
			visited = new boolean[N];
			list = new ArrayList[N];
			
			for(int i=0;i<N;i++) {
				list[i] = new ArrayList<>();
			}
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			
			int sx=0;
			int sy=0;
			
			for(int i=0;i<N;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[i].add(new int[] {a,b});
				
				if(i==0) {
					sx = a;
					sy = b;
				}
			}
			
			dfs(0,0,0);
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.print(sb);
	}
	private static void dfs(int depth, int check, int count) {
		if(depth == N) {
			
			if(check == 1) {
				result = Math.min(result, count);
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] == true) {
				continue;
			}

			int[] temp1 = list[check].get(0);
			int x1 = temp1[0];
			int y1 = temp1[1];
			
			int[] temp2 = list[i].get(0);
			int x2 = temp2[0];
			int y2 = temp2[1];
			
			
			int dist = cal(x1,x2,y1,y2);
			
			if(count+dist > result) {
				continue;
			}
			
			visited[i] = true;
			dfs(depth+1,i,count+dist);
			visited[i] = false;
		}
		
		
	}
	private static int cal(int x1, int x2, int y1, int y2) {
		int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
		return dist;
	}
	
	
}
/*

1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20

3
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
*/