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
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
             
            String str = br.readLine();
            boolean check = true;
             
            String part = "";
            for(int i=0;i<=N-K;i++){
                for(int j=i;j<i+K;j++){
                    part += str.charAt(j);
                }
 
                check = true;
                int l = K-1;
                for(int k=0;k<K/2;k++){
                    if(part.charAt(k) != part.charAt(l)){
                        check = false;
                        break;
                    }
                    l--;
                }
                if(check == true){
                    break;
                }
                part = "";
            }
             
            System.out.printf("#%d ",test_case);
            if(check == false){
                System.out.printf("NONE");
            }else{
                System.out.printf("%s",part);
            }
            System.out.printf("\n");
                 
        }
    }
}