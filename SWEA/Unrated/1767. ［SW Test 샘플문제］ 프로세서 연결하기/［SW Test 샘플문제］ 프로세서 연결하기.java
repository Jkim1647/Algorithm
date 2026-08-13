import java.util.*;
import java.lang.*;
import java.io.*;
 
/*
N*N으로 입력 받고, 외각인 경우 1, 외각이 아닌 core =2 입력
DFS, 백트래킹으로
외각이 아닌 core는 List[int]{} 배열 형태로 받아서. index로 불러오고
각 index 코어별로 for(4방향) 탐색.
벽면까지 가능한지 check 후 while 진행 및 길이 계산 및 map에 반영
이후 다음 dfs로 다음 노드 넘김+core 갯수, 길이 넘김.
다시 길이 초기화.
 
core index가 cores의 갯수와 같으면 탐색이 끝난 것이므로 return
및 최대노드 및 최소길이 갱신
마무리 출력
코어 선택 여부 2^12*12*4 = 4096*12*4 약 20만
*/
class Solution {
 
    static int K;
    static int N;
 
    static ArrayList<int[]> cores;
    static int arr[][];
 
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
 
    static int core_count = 0;
    static int min_corelength = Integer.MAX_VALUE;
 
    public static void main(String[] args)  throws Exception
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
 
        for(int test_case=1;test_case<=K;test_case++){
 
            core_count = 0;
            min_corelength = Integer.MAX_VALUE;
 
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            cores = new ArrayList<>();
                 
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    int temp = Integer.parseInt(st.nextToken());
 
 
                    if(temp == 1){
                        if(i == 0 || j == 0 || i == N-1 || j == N-1){
                            arr[i][j] = temp+1;
                        }
                        else{
                            arr[i][j] = temp;
                            cores.add(new int[]{i,j});    
                        }
                    }
                }
            }
             
            dfs(0,0,0);
 
            int answer = min_corelength;
            System.out.printf("#%d %d\n", test_case, answer);
 
        }
 
    }
 
    private static void dfs(int index, int count, int corelength){
  
        if(index == cores.size()){
            if(core_count < count){
                core_count = count;
                min_corelength = corelength;
            }else if(core_count == count){
                min_corelength = Math.min(min_corelength,corelength);
            }
            return;
        }
        int[] core = cores.get(index);
 
        int x = core[0];
        int y = core[1];
 
        for(int dir=0;dir<4;dir++){
            if(!(coreable(x,y,dir))){
                continue;
            }
 
            int cur_core_length = connectCore(x,y,dir,3);
            dfs(index+1,count+1,corelength+cur_core_length);
            connectCore(x,y,dir,0);
             
        }
        dfs(index+1,count,corelength);
 
 
    }
    private static boolean coreable(int x,int y,int dir){
        int nx = x+dx[dir];
        int ny = y+dy[dir];
 
        while(nx >= 0 && ny >= 0 && nx < N && ny < N){
            if(arr[nx][ny] != 0){
                return false;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
        return true;
    }
    private static int connectCore(int x, int y, int dir, int set){
        int nx = x+dx[dir];
        int ny = y+dy[dir];
 
        int count = 0;
        while(nx >= 0 && ny >= 0 && nx < N && ny < N){
            count++;
            arr[nx][ny] = set;
            nx += dx[dir];
            ny += dy[dir];
        }
        return count;
    }
     
}