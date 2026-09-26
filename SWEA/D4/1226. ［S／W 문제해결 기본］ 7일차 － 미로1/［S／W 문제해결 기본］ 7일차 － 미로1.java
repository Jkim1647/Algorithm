import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    public static void main(String[] args) throws Exception{

        T = 10;
        for(int tc=1;tc<=T;tc++){
            int a = Integer.parseInt(br.readLine());
            int N = 16;
            map = new int[N][N];
            visited = new int[N][N];
            answer = 0;
            Deque<int[]> q = new ArrayDeque<>();

            for(int i=0;i<N;i++){
                String s = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = s.charAt(j) - '0';
                    if(map[i][j] == 2){
                        q.add(new int[] {i,j});
                        visited[i][j] = 1;
                    }
                    if(map[i][j] == 1){
                        visited[i][j] = 1;
                    }
                }
            }

            while(!q.isEmpty()){
                int temp[] = q.poll();

                int cx = temp[0];
                int cy = temp[1];

                for(int dir=0;dir<4;dir++){
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                        continue;
                    }
                    if(visited[nx][ny] == 1){
                        continue;
                    }

                    visited[nx][ny] = 1;
                    q.add(new int[] {nx,ny});

                    if(map[nx][ny] == 3){
                        answer = 1;
                    }
                }
            }

            sb.append("#"+tc+" "+answer+"\n");

            
        }
        System.out.print(sb);
        
    }
}