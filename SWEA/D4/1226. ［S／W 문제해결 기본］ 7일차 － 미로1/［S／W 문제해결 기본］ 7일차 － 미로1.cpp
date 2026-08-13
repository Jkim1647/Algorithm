#include<iostream>
#include<vector>
#include<string>
#include <queue>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    T = 10;
    //cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int test;
        cin >> test;
         
        int n,m;
        n = 16; m = 16;
         
        vector<vector<int>> arr(n,vector<int>(m,0));
         
        //queue<pair<int,int>> q;
        queue<vector<int>> q;
         
        int visited[16][16] = {};
         int dx[4] = {0,1,0,-1};
         int dy[4] = {-1,0,1,0};
         
        for(int i=0;i<16;i++){
            string s;
            cin >> s;
            for(int j=0;j<16;j++){
                arr[i][j] = s[j]- '0';
                 
                if(arr[i][j] == 2){
                    q.push({i,j});
                    visited[i][j] = 1;
                }
            }
        }
 
        int poss = 0;
         
        while(!q.empty()){
            vector<int> cur = q.front();
            int cur_x = cur[0];
            int cur_y = cur[1];
            /*
            int cur_x = q.front().first;
            int cur_y = q.front().second;*/
            q.pop();
 
            if(arr[cur_x][cur_y] == 3){
                poss = 1;
            }
 
            for(int i=0;i<4;i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                 
                if(nx >= 0 && nx < 16 && ny >= 0 && ny < 16){
                    if((arr[nx][ny] != 1) && (visited[nx][ny] == 0)){
                        q.push({nx,ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
         
        cout << "#" << test << " " << poss << "\n";
 
    }
    return 0;
}