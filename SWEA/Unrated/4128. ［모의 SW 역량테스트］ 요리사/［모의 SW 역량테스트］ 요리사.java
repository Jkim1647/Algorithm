import java.io.*;
import java.util.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
     
    static int K,N;
    static int[][] map;
 
    static boolean used[];
    static int result;
     
    public static void main(String[] args) throws Exception{
        K = Integer.parseInt(br.readLine());
         
        for(int test_case=1;test_case<=K;test_case++) {
            N = Integer.parseInt(br.readLine());
             
            map = new int[N][N];
            used = new boolean[N];
            result = Integer.MAX_VALUE;
             
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
             
            comb(0,0);
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(result)
            .append("\n");
        }
        System.out.println(sb);
         
    }
 
    private static void comb(int depth, int start) {
         
        if(depth == N/2) {
            int food1 = 0;
            int food2 = 0;
            for(int i=0;i<N;i++) {
                //System.out.printf("%b ",used[i]);
                 
                for(int j=i+1;j<N;j++) {
                    if(used[i] && used[j]) {
                        food1 += map[i][j]+map[j][i];
                    }
                    if(!used[i] && !used[j]) {
                        food2 += map[i][j]+map[j][i];
                    }
                }
                 
            }
            result = Math.min(result, Math.abs(food1-food2));
            //System.out.printf("%d \n",Math.abs(food1-food2));
            return;
        }
         
        for(int i=start;i<N;i++) {
            used[i] = true;
            comb(depth+1,i+1);
            used[i] = false;
        }
         
         
    }
     
     
}