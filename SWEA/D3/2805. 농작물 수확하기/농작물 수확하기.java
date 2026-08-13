import java.util.*;
import java.io.*;
 
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int K,N;
    static int[][] map;
    static int[][] visited;
    static Deque<int[]> q;
    static int result;
     
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
     
    public static void main(String[] args) throws Exception{
        K = Integer.parseInt(br.readLine());
         
        for(int test_case = 1;test_case<=K;test_case++) {
            N = Integer.parseInt(br.readLine());
            q = new ArrayDeque<>();
             
            q.add(new int[] {N/2,N/2});
            result = 0;
            visited = new int[N][N];
             
            visited[N/2][N/2] = 1;
             
            map = new int[N][N];
             
            for(int i=0;i<N;i++) {
                String temp = br.readLine();
                for(int j=0;j<N;j++) {
                    map[i][j] = (int)temp.charAt(j) - '0';
                }
            }
             
            while(!q.isEmpty()) {
                int temp[] = q.poll();
                int cx = temp[0];
                int cy = temp[1];
                 
                //System.out.println("asd2");
                for(int dir=0;dir<4;dir++) {
                    int nx = cx+dx[dir];
                    int ny = cy+dy[dir];
                     
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                     
                    if(visited[nx][ny] != 0) {
                        continue;
                    }
                     
                    visited[nx][ny] = visited[cx][cy]+1;
                    q.add(new int[] {nx,ny});
                    //System.out.println("asd");
                }
            }
 
            /*
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    sb.append(visited[i][j])
                    .append(" ");
                }
                sb.append("\n");
            }
             
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    sb.append(map[i][j])
                    .append(" ");
                }
                sb.append("\n");
            }*/
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j] <= ((N/2)+1)) {
                        result += map[i][j];
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