import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int arr[][];
    static int T,N;
    static int result;
     
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
     
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1;test_case<=T;test_case++) {
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
                     
                    int cnt = arr[i][j];
                     
                    for(int dir=0;dir<4;dir++) {
                        int nx = i;
                        int ny = j;
                        for(int k=0;k<N;k++) {
                            nx += dx[dir];
                            ny += dy[dir];
                            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                cnt += arr[nx][ny];
                            }
                             
                        }
                        result = Math.max(result, cnt);
                    }
                     
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
}