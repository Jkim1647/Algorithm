import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T,N,K,M;
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
			M = N/4;

			TreeSet<Long> set = new TreeSet<>(Collections.reverseOrder());
			String temp = br.readLine();
			
			for(int k=0;k<M;k++) {
				for(int i=0;i<N;i+=M) {
					String part = temp.substring(i, i + M);
                    long value = Long.parseLong(part, 16);
                    set.add(value);
				}
				temp = temp.substring(1) + temp.charAt(0);
			}
			
			long answer = 0;
			int count = 0;
			for(long value : set) {
				if(count == K-1) {
					answer = value;
					break;
				}
				count++;
			}
			
			sb.append("#")
			.append(test_case)
			.append(" ")
			.append(answer)
			.append("\n");
		}
		System.out.print(sb);
	}
}