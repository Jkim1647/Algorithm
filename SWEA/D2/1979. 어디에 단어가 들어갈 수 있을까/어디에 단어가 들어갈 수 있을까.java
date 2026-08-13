import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static int T,N,K;
    static int result;
    static int arr[][];
     
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
         
        sb = new StringBuilder();
        for(int test_case = 1;test_case<=T;test_case++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
             
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=0;i<N;i++) {
                int count = 0;
                for(int j=0;j<N;j++) {
                    if(arr[i][j] == 1) {
                        count++;
                         
                        if(count == K) {
                            if(j == N-1) {
                                result++;
                            }else {
                                if(arr[i][j+1] == 0) {
                                    result++;
                                }
                            }
                        }
                    }
                    else {
                        count=0;
                    }
                }
            }
             
            for(int i=0;i<N;i++) {
                int count =0;
                for(int j=0;j<N;j++) {
                    if(arr[j][i] == 1) {
                        count++;
                        if(count == K) {
                            if(j == N-1) {
                                result++;
                            }else {
                                if(arr[j+1][i] == 0) {
                                    result++;
                                }
                            }
                        }
                    }else {
                        count = 0;
                    }
                }
            }
             
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(result)
            .append("\n");
        }
        System.out.print(sb);
    }
}