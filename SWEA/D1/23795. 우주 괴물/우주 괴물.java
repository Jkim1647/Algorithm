import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static int T,N;
    static StringTokenizer st;
     
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
     
    static int sx,sy;
     
    public static void main(String args[]) throws Exception
    {
        T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sx = -1;
            sy = -1;
            N = Integer.parseInt(br.readLine());
             
            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 2){
                        sx = i;
                        sy = j;
                    }
                }
            }
             
             
            for(int dir=0;dir<4;dir++){
                int nx = sx + dx[dir];
                int ny = sy + dy[dir];
                 
                while(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    if(arr[nx][ny] == 1){
                        break;
                    }
                    arr[nx][ny] = 1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
             
            int answer = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j] == 0){
                        answer++;
                    }
                }
            }
            sb.append("#"+test_case + " " + answer + "\n");
 
        }
        System.out.print(sb);
    }
}