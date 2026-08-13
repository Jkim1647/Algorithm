import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
     
    static int K,N;
    static int[][] map;
    static boolean result;
     
    static int dx[] = {1,-1,0,0,1,1,-1,-1};
    static int dy[] = {0,0,1,-1,1,-1,-1,1};
     
    public static void main(String[] args) throws Exception{
         
        K = Integer.parseInt(br.readLine());
         
        for(int test_case = 1;test_case<=K;test_case++) {
            N = Integer.parseInt(br.readLine());
 
            map = new int[N][N];
 
             
            for(int i=0;i<N;i++) {
                String temp = br.readLine();
                for(int j=0;j<N;j++) {
                    char ch = temp.charAt(j);
                    if(ch == '.') {
                        map[i][j] = 0;
                    }else {
                        map[i][j] = 1;
                    }
                }
            }
             
            result = false;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    check(i,j);
                }
            }
             
            sb.append("#")
            .append(test_case)
            .append(" ");
            if(result == true) {
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
 
        }
        System.out.print(sb);
         
    }
 
    private static void check(int i, int j) {
         
         
        for(int dir=0;dir<8;dir++) {
            int count = 0;
            if(map[i][j] == 1) {
                count = 1;
            }
             
            int cx = i;
            int cy = j;
            while(true) {
                int nx = cx+dx[dir];
                int ny = cy+dy[dir];
                 
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    break;
                }
                if(map[nx][ny] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }           
                 
                if(count == 5) {
                    result = true;
                }
                 
                cx = nx;
                cy = ny;
            }
        }
    }
     
}