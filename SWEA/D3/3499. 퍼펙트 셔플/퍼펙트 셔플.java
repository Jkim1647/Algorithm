import java.io.*;
import java.util.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static String[] arr;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			
			arr = new String[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i] = st.nextToken();
			}
			/*

			for(int i=0;i<N;i++) {
				System.out.println(arr[i]);
			}
			*/
			System.out.print("#"+tc+" ");
			
			
			
			if(N % 2 == 0) {
				for(int i=0;i<N/2;i++) {
					System.out.printf("%s ",arr[i]);
					System.out.printf("%s ",arr[i+N/2]);
				}
			}else {
				for(int i=0;i<N/2;i++) {
					System.out.printf("%s ",arr[i]);
					System.out.printf("%s ",arr[(i+N/2)+1]);
				}
				System.out.printf("%s ",arr[N/2]);
			}
			System.out.println();
			
			
			
			
		}
	}
	
}





