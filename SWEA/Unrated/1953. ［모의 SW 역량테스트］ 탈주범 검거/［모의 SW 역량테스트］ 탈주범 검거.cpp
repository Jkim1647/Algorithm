#include<iostream>
#include <vector>
#include <queue>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
     
    int dy[4] = {0,1,0,-1};
    int dx[4] = {1,0,-1,0};
 
    cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int n,m,start_x,start_y,time;
         
        cin >> n >> m >> start_x >> start_y >> time;
        vector<vector<int>> arr(n,vector<int>(m,0));
        queue<vector<int>> q;
        int visited[n][m] = {};
         
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin >> arr[i][j];
            }
        }
        q.push({start_x,start_y,1});
        visited[start_x][start_y] = 1;
        int move_time = 0;
         
        while(!q.empty()){
            vector<int> cur = q.front();
            q.pop();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int cur_t = cur[2];
   
            for(int i=1;i<=4;i++){
                int nx = cur_x + dx[i-1];
                int ny = cur_y + dy[i-1];
 
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && cur_t < time){
                    int nn = arr[nx][ny];
                    int cx = arr[cur_x][cur_y];
                     
                    if(cx == 1){
                        if(
                            (i == 1 && (nn == 1 || nn == 2 || nn == 4 || nn == 7)) ||
                            (i == 2 && (nn == 1 || nn == 3 || nn == 6 || nn == 7)) ||
                            (i == 3 && (nn == 1 || nn == 2 || nn == 5 || nn == 6)) ||
                            (i == 4 && (nn == 1 || nn == 3 || nn == 4 || nn == 5))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                         
                    }
                    else if(cx == 2){
                        if(
                            (i == 1 && (nn == 1 || nn == 2 || nn == 4 || nn == 7)) ||
                            (i == 3 && (nn == 1 || nn == 2 || nn == 5 || nn == 6))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                    }
                    else if(cx == 3){
                        if(
                            (i == 2 && (nn == 1 || nn == 3 || nn == 6 || nn == 7)) ||
                            (i == 4 && (nn == 1 || nn == 3 || nn == 4 || nn == 5))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                    }
                    else if(cx == 4){
                        if(
                            (i == 2 && (nn == 1 || nn == 3 || nn == 6 || nn == 7)) ||
                            (i == 3 && (nn == 1 || nn == 2 || nn == 5 || nn == 6))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                    }
                    else if(cx == 5){
                        if(
                            (i == 1 && (nn == 1 || nn == 2 || nn == 4 || nn == 7)) ||
                            (i == 2 && (nn == 1 || nn == 3 || nn == 6 || nn == 7))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                    }
                    else if(cx == 6){
                        if(
                            (i == 1 && (nn == 1 || nn == 2 || nn == 4 || nn == 7)) ||
                            (i == 4 && (nn == 1 || nn == 3 || nn == 4 || nn == 5))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                    }
                    else if(cx == 7){
                        if(
                            (i == 3 && (nn == 1 || nn == 2 || nn == 5 || nn == 6)) ||
                            (i == 4 && (nn == 1 || nn == 3 || nn == 4 || nn == 5))
                        ){
                            visited[nx][ny] = 1;
                            q.push({nx,ny,cur_t+1});
                        }
                    }
                }         
            }
        }
         
        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 1){
                    answer++;
                }
            }
        }
         
        cout << "#" <<  test_case  << " "<< answer << "\n";
 
    }
    return 0;
}