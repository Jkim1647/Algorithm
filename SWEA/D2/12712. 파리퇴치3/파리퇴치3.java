import java.util.*;
import java.io.*;
 
class Solution
{   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static int T,N,spray;
    static int arr[][];
     
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
     
 
    static int dx2[] = {-1,-1,1,1};
    static int dy2[] = {-1,1,-1,1};
    static int count1;
    static int count2;
     
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
         
        sb = new StringBuilder();
        for(int test_case=1;test_case<=T;test_case++) {
            st = new StringTokenizer(br.readLine());
             
             
            N = Integer.parseInt(st.nextToken());
            spray = Integer.parseInt(st.nextToken());
             
            arr = new int[N][N];
             
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    count1 = arr[i][j];
                    count2 = arr[i][j];
                     
                    for(int dir=0;dir<4;dir++) {
                        int nx = i;
                        int ny = j;
                         
                                 
                        for(int k=0;k<spray-1;k++) {
 
                            nx = nx+dx[dir];
                            ny = ny+dy[dir];
                             
                            if(nx >= 0 && nx < N && ny >= 0 && ny <N) {
                                count1 += arr[nx][ny]; 
                            }
                        }
                         
                    }
                     
 
                    for(int dir=0;dir<4;dir++) {
                        int nx = i;
                        int ny = j;
                         
                                 
                        for(int k=0;k<spray-1;k++) {
 
                            nx = nx+dx2[dir];
                            ny = ny+dy2[dir];
                             
                            if(nx >= 0 && nx < N && ny >= 0 && ny <N) {
                                count2 += arr[nx][ny]; 
                            }
                        }
                         
                    }
 
                    answer = Math.max(answer, count2);
                    answer = Math.max(answer, count1);
                     
                }
            }
 
             
            sb.append("#")
            .append(test_case)
            .append(" ")
            .append(answer)
            .append("\n");
             
        }
 
        System.out.println(sb);
         
    }
 
}