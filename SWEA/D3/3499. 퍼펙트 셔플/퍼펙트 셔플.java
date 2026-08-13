import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
     
    static int K,N;
    static String result;
    static String arr[];
    public static void main(String[] args) throws Exception{
        K = Integer.parseInt(br.readLine());
         
        for(int test_case=1;test_case<=K;test_case++) {
             
            N = Integer.parseInt(br.readLine());
            arr = new String[N];
            result = "";
             
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = st.nextToken();
            }
             
            if(N%2 == 0) {
                for(int i=0;i<N/2;i++) {
                    result += arr[i];
                    result += " ";
                    result += arr[i+N/2];
                    result += " ";
                }
            }else {
                for(int i=0;i<N/2;i++) {
                    result += arr[i];
                    result += " ";
                    result += arr[i+N/2+1];
                    result += " ";
                }
                result += arr[N/2];
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