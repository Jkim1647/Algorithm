import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
                                        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
             
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }
             
            int count = 0;
            for(int i=0;i<N;i++){
                if(arr1[i] == arr2[i]){
                    continue;
                }
                else{
                    count++;
                    for(int j=i;j<N;j++){
                        if(arr1[j] == 1){
                            arr1[j] = 0;
                        }else{
                            arr1[j] = 1;
                        }
                    }
                }
            }
             
            System.out.printf("#%d %d\n",test_case,count);
            /*
            System.out.printf("\n");
            for(int i=0;i<N;i++){
                System.out.printf("%d",arr1[i]);
            }
            System.out.printf("\n");
            for(int i=0;i<N;i++){
                System.out.printf("%d",arr2[i]);
            }*/
 
        }
    }
}