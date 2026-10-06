import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T,N;
	static int[] x,y;
	static double E;
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			x = new int[N];
			y = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			boolean visited[] = new boolean[N];
			long[] minDist = new long[N];
			
			Arrays.fill(minDist, Long.MAX_VALUE);
			
			minDist[0] = 0;
			
			long sum = 0;
			
			for(int i=0;i<N;i++) {
				long min = Long.MAX_VALUE;
				int cur = -1;
				
				for(int j=0;j<N;j++) {
					if(visited[j] == false && minDist[j] < min) {
						min = minDist[j];
						cur = j;
					}
				}
				
				visited[cur] = true;
				sum += min;
				
				for(int next=0;next<N;next++) {
					if(visited[next]) {
						continue;
					}
					
					long dx = x[cur] - x[next];
					long dy = y[cur] - y[next];
					
					long cost = dx*dx + dy*dy;
					
					if(cost < minDist[next]) {
						minDist[next] = cost;
					}
				}
			}
			
			long answer = Math.round(sum*E);
			sb.append("#"+tc+" "+answer+"\n");
		}
		System.out.print(sb);
	}
}