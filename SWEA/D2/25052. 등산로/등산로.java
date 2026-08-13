import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int T,N;
    static int arr[][];
    static int result;
     
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
     
    public static void main(String[] args) throws Exception{
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
         
        for(int test_case=1;test_case<=T;test_case++) {
             
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            result = 0;
             
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    dfs(i,j,0);//x,y,count
                }
            }
             
 
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(result)
            .append("\n");
        }
        System.out.print(sb);
    }
 
    private static void dfs(int cx, int cy, int count) {
        boolean go_flag = false;
        for(int dir=0;dir<4;dir++) {
            int nx = cx+dx[dir];
            int ny = cy+dy[dir];
             
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(arr[nx][ny] < arr[cx][cy]) {
                    go_flag = true;
                }
            }
        }
        if(go_flag == false) {
            result = Math.max(result, ++count);
            return;
        }
         
        int cur_value = arr[cx][cy];
        int next_x = 0;
        int next_y = 0;
         
        for(int dir=0;dir<4;dir++) {
            int nx = cx+dx[dir];
            int ny = cy+dy[dir];
             
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(cur_value > arr[nx][ny]) {
                    next_x = nx;
                    next_y = ny;
                    cur_value = arr[nx][ny];
                     
                }
            }
        }
        dfs(next_x,next_y,++count);
         
    }
     
}