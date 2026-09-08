
import java.io.*;
import java.util.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T,N,M,K;
	static int[][] map;
	static int[] arr;
	static int[] used;
	static int result;
	
	public static void main(String[] args) throws Exception{
		
		T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case=1;test_case<=T;test_case++) {
			
			st = new StringTokenizer(br.readLine().trim());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			arr = new int[N];
			used = new int[N];
			result = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			/*
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.printf("%d ",map[i][j]);
				}
				System.out.println();
			}
			*/

			//boolean test = cal();
			//System.out.printf("test=%b \n",test);
			//dfs2(0);
			dfs(0);
			
			sb.append("#"+test_case+" "+result+"\n");
		}
		System.out.print(sb);
	}

	private static void dfs2(int depth) {
		if(depth == N) {
			int count = 0;
			for(int i=0;i<N;i++) {
				if(used[i] != 0) {
					count++;
				}
			}
			if(result != Integer.MAX_VALUE && result < count) {
				
			}
			System.out.println(Arrays.toString(used));
			
			return;
		}
		used[depth] = 0;
		dfs2(depth+1);

		used[depth] = 1;
		dfs2(depth+1);
		
		used[depth] = 2;
		dfs2(depth+1);
		

	}
	
	private static void dfs(int depth) {
		if(depth == N) {
			//System.out.println(Arrays.toString(used));
			
			int count = 0;
			for(int i=0;i<N;i++) {
				if(used[i] != 0) {
					count++;
				}
			}
			if(result == Integer.MAX_VALUE || result >= count) {
				
				int map_back[][] = new int[N][M];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map_back[i][j] = map[i][j];
					}
				}
				change();
				
				boolean find = cal();
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map[i][j] = map_back[i][j];
					}
				}
				//System.out.println(find);
				
				if(find == true) { // 테스트 통과 하면
					int result_count = 0;
					for(int i=0;i<N;i++) {
						if(used[i] != 0) {
							result_count++;
						}
					}
					result = Math.min(result, result_count);
					if(result == 1) {
						//System.out.println(Arrays.toString(used));
						
					}
				}
				
			}
			
			
			
			return;
		}
		used[depth] = 0;
		dfs(depth+1);

		used[depth] = 1;
		dfs(depth+1);
		
		used[depth] = 2;
		dfs(depth+1);
		

	}

	private static void change() {
		for(int i=0;i<N;i++) {
			if(used[i] == 0) {
				
			}else {
				if(used[i] == 1) {
					for(int j=0;j<M;j++) {
						map[i][j] = 1;
					}
					//System.out.println("check1");
				}else if(used[i] == 2) {
					for(int j=0;j<M;j++) {
						map[i][j] = 0;
					}
					//System.out.println("check2");
				}
			}
			
		}
		/*
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.printf("%d ",map[i][j]);
			}
			System.out.println();
		}
		*/
	}
	
	private static boolean cal() {
		
		int safe_count = 0;
		for(int j=0;j<M;j++) {
			int row_count0 = 0;
			int row_count1 = 0;
			int safe_flag = 0;
			for(int i=0;i<N;i++) {
				if(map[i][j] == 0) {
					//System.out.print('A');
					row_count0++;
					row_count1 = 0;
				}else {
					row_count1++;
					row_count0 = 0;
					//System.out.print('B');
				}
				if(row_count1 >= K || row_count0 >= K) { //K개 이상 연속되면 나가기
					safe_count++;
					safe_flag = 1;
					break;
				}
			}
			//System.out.printf("safe_count = %d \n",safe_count);
			//System.out.printf("safe_flag = %d \n",safe_flag);
			if(safe_flag == 0) {
				break;
			}
			//System.out.println();
		}
		if(safe_count == M) {
			//System.out.printf("safe_count = %d \n",safe_count);
			return true;
		}
		return false;
		
	}
	
	
}
