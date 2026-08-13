import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br;
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int T,N;
     
    public static void main(String args[]) throws Exception
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
             
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
            int sum1 = 0;
            int sum2 = 0;
             
            int cha_min = Integer.MAX_VALUE;
            int cha_min_x = -1;
             
            for(int i=0;i<N;i++) {
 
                for(int k=0;k<=i;k++) {
                    sum1 += arr[k];
                }
                for(int k=i+1;k<N;k++) {
                    sum2 += arr[k];
                }
                int temp = Math.abs(sum1 - sum2);
                if(cha_min > temp) {
                    cha_min = temp;
                    cha_min_x = i+1;
                }
                sum1 = 0;
                sum2 = 0;
            }
             
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(cha_min_x)
            .append(" ")
            .append(cha_min)
            .append("\n");
 
        }
        System.out.println(sb);
    }
}