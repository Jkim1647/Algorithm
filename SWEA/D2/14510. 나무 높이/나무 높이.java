import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T,N;
    static int arr[];

    public static void main(String[] args) throws Exception{

        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){

            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            int max = 0;
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max,arr[i]);
            }

            int one_count=0;
            int two_count=0;
            
            for(int i=0;i<N;i++){
                if((max-arr[i]) % 2 == 0){
                    if((max-arr[i]) != 0){
                        int temp = (max-arr[i])/2;
                        two_count+=temp;
                    }
                }else{
                    int temp = ((max-arr[i])-1)/2;
                    two_count+=temp;
                    one_count++;
                }
            }
            //System.out.printf("tc=%d %d %d\n",tc,one_count,two_count);
            
            int result = 0;
            if(one_count > two_count){
                result = one_count*2 - 1;
            }
            else if(one_count == two_count){
                result = one_count*2;
            }
            else if(one_count < two_count){
                while(two_count - one_count > 1){
                    two_count--;
                    one_count+=2;
                }
                if(two_count == one_count){
                    result = one_count*2;
                }
                if(two_count-one_count == 1){
                    result = two_count*2;
                }
                if(one_count > two_count){
                    result = one_count + two_count;
                }
            }
            //System.out.printf("%d %d %d\n\n",one_count,two_count,result);

            sb.append("#"+tc+" "+result+"\n");
            
        }
        System.out.print(sb);
    }
}