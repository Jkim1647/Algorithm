import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb;
    static StringTokenizer st;
    static int K,N,M;
    static int arr1[];
    static int arr2[];
     
    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
         
        for(int test_case = 1;test_case<=K;test_case++) {
             
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
             
            int num1 = -1;
             
            int arr2_ch = 0;
            boolean answer = false;
             
            for(int i=0;i<N;i++) {
                num1 = arr1[i];
                if(num1 == arr2[arr2_ch]) {
                    arr2_ch++;
                    if(arr2_ch == M-1) {
                        answer = true;
                        break;
                    }
                }
                 
            }
             
            sb.append("#")
            .append(test_case)
            .append(" ");
            if(answer == true) {
                sb.append("YES");
            }else {
                sb.append("NO");
            }
            sb.append("\n");
             
        }
        System.out.print(sb);
         
    }
 
     
}