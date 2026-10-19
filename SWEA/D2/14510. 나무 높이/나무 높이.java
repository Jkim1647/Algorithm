import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T,N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int max = 0;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			
			int odd_count = 0;
			int ass_count = 0;
			
			for(int i=0;i<N;i++) {
				int diff = max - arr[i];
				
				if(diff % 2 == 0) {
					odd_count += diff / 2;
				}else {
					odd_count += diff / 2;
					ass_count+=1;
				}
			}
			
			if(odd_count > ass_count+1) {
				while(odd_count > ass_count+1) {
					odd_count--;
					ass_count+=2;
				}
			}
			int result = 0;
			if(odd_count > ass_count) {
				result = odd_count + ass_count;
				result++;
			}else if(odd_count < ass_count) {		
				result = ass_count*2;
				result--;
			}else if(odd_count == ass_count) {
				result = odd_count + ass_count;
			}
			
			sb.append("#"+tc+" "+result+"\n");
			
		}
		System.out.print(sb);
	}
}
