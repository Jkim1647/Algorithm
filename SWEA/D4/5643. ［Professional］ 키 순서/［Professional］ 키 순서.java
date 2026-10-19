import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T,N,M;
	static int[] arr;
	static ArrayList<int[]>[] graph_down;
	static ArrayList<int[]>[] graph_up;
	static int result;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			graph_down = new ArrayList[N+1];
			graph_up = new ArrayList[N+1];
			arr = new int[N+1];
			Deque<Integer> q = new ArrayDeque<>();
			Deque<Integer> q2 = new ArrayDeque<>();
			result = 0;
			
			for(int i=0;i<=N;i++) {
				graph_down[i] = new ArrayList<>();
				graph_up[i] = new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				graph_down[a].add(new int[] {b});
				graph_up[b].add(new int[] {a});
			}
			
			int[] down = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				q.add(i);
				
				boolean[] visited = new boolean[N+1];
				Arrays.fill(visited, false);
				int count = 0;
				while(!q.isEmpty()) {
					int temp = q.poll();
					visited[temp] = true;
					for(int[] edge : graph_down[temp]) {
						int a = edge[0];
						
						if(visited[a] == false) {
							q.add(a);
							count++;
						}
						
						visited[a] = true;
					}
				}
				
				down[i] = count;
			}

			int[] up = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				q2.add(i);
				
				boolean[] visited = new boolean[N+1];
				Arrays.fill(visited, false);
				int count = 0;
				while(!q2.isEmpty()) {
					int temp = q2.poll();
					visited[temp] = true;
					for(int[] edge : graph_up[temp]) {
						int a = edge[0];
						
						if(visited[a] == false) {
							q2.add(a);
							count++;
						}
						
						visited[a] = true;
					}
				}
				
				up[i] = count;
			}

			for(int i=1;i<=N;i++) {
				int sum = up[i] + down[i];
				if(sum == N-1) {
					result++;
				}
			}
			
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.print(sb);
	}

}