class Solution {
    public int[] solution(int N) {
        
        
        int[][] map = new int[N][N];
        
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                map[i][j] = -1;
            }
        }

        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        
        int num = 1;
        int count = 0;
        
        for(int i=1;i<=N;i++){
            count+=i;
        }
        int[] answer = new int[count];

        int x=0;
        int y=0;
        int dir = 0;
        int nx = 0;
        int ny = 0;
        
        while(count>0){
            map[x][y] = num;
            
            nx += dx[dir];
            ny += dy[dir];

            if((nx >= N || ny >= N || nx < 0 || ny < 0) || map[nx][ny] > 0){

                nx -= dx[dir];
                ny -= dy[dir];
                dir = (++dir) % 3;
                nx += dx[dir];
                ny += dy[dir];          
            }
            
            if(nx<N && ny < N && nx >= 0 && ny >= 0){
                
                x = nx;
                y = ny;
                num++;
                count--;
            }
        }
    
        int index = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] != -1){  
                    answer[index++] = map[i][j];
                }
            }
        }        
        return answer;

    }
}
