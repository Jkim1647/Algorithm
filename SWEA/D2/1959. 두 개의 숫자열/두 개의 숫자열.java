import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int T,N,M;
    static int result;
    static int arr1[];
    static int arr2[];
     
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
         
        sb = new StringBuilder();
        for(int test_case=1;test_case<=T;test_case++) {
             
            st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            arr1 = new int[N];
            arr2 = new int[M];
             
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }
             
            int sum = 0;
            if(N>M) {
                for(int i=0;i<=N-M;i++) {
                    for(int j=0;j<M;j++) {
                        sum += arr1[i+j] * arr2[j];
                    }
                    result = Math.max(result, sum);
                    sum = 0;
                }
            }else {
                for(int i=0;i<=M-N;i++) {
                    for(int j=0;j<N;j++) {
                        sum += arr1[j] * arr2[i+j];
                    }
                    result = Math.max(result, sum);
                    sum = 0;
                }
            }
             
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(result)
            .append("\n");
            result = 0;
        }
        System.out.println(sb);
    }
}