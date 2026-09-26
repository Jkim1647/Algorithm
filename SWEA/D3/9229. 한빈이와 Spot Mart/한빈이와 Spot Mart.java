import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T;
    static int N;
    static int[] arr;
    static int target;
    static int result;
    public static void main(String[] args) throws Exception{

       T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            arr = new int[N];
            result = -1;
            
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));

            int start = 0;
            int end = N-1;
            while(end>start){
                int sum = arr[start] + arr[end];
                if(sum <= target){
                    result = Math.max(result,sum);
                }
                
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
            
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.print(sb);
        
    }
}