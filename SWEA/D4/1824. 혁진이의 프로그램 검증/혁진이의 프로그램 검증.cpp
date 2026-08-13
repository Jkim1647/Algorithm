#include<iostream>
#include <vector>
#include <queue>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
     
    cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int n,m;
         
        cin >> n >> m;
         
        vector<vector<char>> arr(n,vector<char>(m));
         
        int poss = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cin >> arr[i][j];
                if(arr[i][j] == '@'){ poss = 1; }
            }
        }
         
        if(poss == 0){
            cout << "#" << test_case << " NO\n";
            continue;
        }
         
        int visited[21][21][16][5] = {0,}; // x,y,mem,direct
        //direction: 1 오른쪽, 2 아래, 3 왼쪽, 4 위
         
        queue<vector<int>> q;
         
        q.push({0,0,0,1});
        visited[0][0][0][1] = 1;
         
        int answer = 0;
         
        while(!q.empty()){
            vector<int> cur = q.front();
            q.pop();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int mem = cur[2];
            int dir = cur[3];
             
            if(arr[cur_x][cur_y] == '@'){
                answer = 1;
                break;
            }
             
            //direction: 1 오른쪽, 2 아래, 3 왼쪽, 4 위
            if(arr[cur_x][cur_y] == '<'){ dir = 3; }
            else if(arr[cur_x][cur_y] == '>'){ dir = 1; }
            else if(arr[cur_x][cur_y] == '^'){ dir = 4; }
            else if(arr[cur_x][cur_y] == 'v'){ dir = 2; }
             
            else if(arr[cur_x][cur_y] == '_'){
                if(mem == 0){ dir = 1; }
                else{ dir = 3; }
            }
            else if(arr[cur_x][cur_y] == '|'){
                if(mem == 0){ dir = 2; }
                else{ dir = 4; }
            }
            else if(arr[cur_x][cur_y] == '.'){
            }
            else if(arr[cur_x][cur_y] == '0'){ mem = 0; }
            else if(arr[cur_x][cur_y] == '1'){ mem = 1; }
            else if(arr[cur_x][cur_y] == '2'){ mem = 2; }
            else if(arr[cur_x][cur_y] == '3'){ mem = 3; }
            else if(arr[cur_x][cur_y] == '4'){ mem = 4; }
            else if(arr[cur_x][cur_y] == '5'){ mem = 5; }
            else if(arr[cur_x][cur_y] == '6'){ mem = 6; }
            else if(arr[cur_x][cur_y] == '7'){ mem = 7; }
            else if(arr[cur_x][cur_y] == '8'){ mem = 8; }
            else if(arr[cur_x][cur_y] == '9'){ mem = 9; }
            else if(arr[cur_x][cur_y] == '+'){
                mem++;
                if(mem == 16) { mem = 0; }
            }
            else if(arr[cur_x][cur_y] == '-'){
                mem--;
                if(mem < 0) { mem = 15; }
            }
             
             
            //direction: 1 오른쪽, 2 아래, 3 왼쪽, 4 위
             
            if(arr[cur_x][cur_y] == '?'){
                for(int i=1;i<=4;i++){
                    int nx = cur_x;
                    int ny = cur_y;
                     
                    if(i == 1){
                        ny++;
                        if(ny == m) ny = 0;
                    }
                    else if(i == 2){
                        nx++;
                        if(nx == n) nx = 0;
                    }
                    else if(i == 3){
                        ny--;
                        if(ny < 0) ny = m-1;
                    }
                    else if(i == 4){
                        nx--;
                        if(nx < 0) nx = n-1;
                    }
                    if(visited[nx][ny][mem][i] == 0){
                        visited[nx][ny][mem][i] = 1;
                        q.push({nx,ny,mem,i});
                    }
 
                }
            }
            else{
                int nx = cur_x;
                int ny = cur_y;
                 
                if(dir == 1){
                    ny++;
                    if(ny == m) ny = 0;
                }
                else if(dir == 2){
                    nx++;
                    if(nx == n) nx = 0;
                }
                else if(dir == 3){
                    ny--;
                    if(ny < 0) ny = m-1;
                }
                else if(dir == 4){
                    nx--;
                    if(nx < 0) nx = n-1;
                }
 
                if(visited[nx][ny][mem][dir] == 0){
                    visited[nx][ny][mem][dir] = 1;
                    q.push({nx,ny,mem,dir});
                }
            }
             
             
            //? 이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
 
        }
         
        if(answer == 1){
            cout << "#" << test_case << " YES\n";
        }
        else{
            cout << "#" << test_case << " NO\n";
        }
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}