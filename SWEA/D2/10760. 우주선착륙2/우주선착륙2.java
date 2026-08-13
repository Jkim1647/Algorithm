import java.util.*;
import java.io.*;
 
public class Solution {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb;
    static StringTokenizer st;
     
    static int T,N,M;
     
    static int arr[][];
 
    static int dx[] = {1,-1,0,0,-1,-1,1,1};
    static int dy[] = {0,0,1,-1,1,-1,1,-1};
    static int answer;
     
    public static void main(String[] args) throws Exception{
         
        T = Integer.parseInt(br.readLine());
         
        sb = new StringBuffer();
         
        for(int test_case=1;test_case<=T;test_case++) {
             
            st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            arr = new int[N][M];
             
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    int c_count = 0;
                     
                    for(int dir=0;dir<8;dir++) {
                        int nx = i+dx[dir];
                        int ny = j+dy[dir];
                         
                        if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if(arr[i][j] > arr[nx][ny]) {
                                c_count++;
                            }
                        }
                    }
                    if(c_count >= 4) {
                        answer++;
                    }
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