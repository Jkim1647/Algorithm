#include<iostream>
#include <string>
#include <set>
#include <algorithm>
 
using namespace std;
 
 
string number;
int change;
int answer;
 
set<string> visited[11];
 
void dfs(string cur,int  dept){
    if(dept == change){
        answer = max(answer,stoi(cur));
        return;
    }
     
    if(visited[dept].count(cur)){
        return;
    }
       visited[dept].insert(cur);
        
       int len = cur.size();
        
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                swap(cur[i],cur[j]);
                dfs(cur,dept+1);
                swap(cur[i],cur[j]);
                     
            }
       }
}
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
 
    cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
         
        cin >> number >> change;
         
        for(int i=0;i<=10;i++){
            visited[i].clear();
        }
        answer= 0;
         
        dfs(number,0);
         
        cout << "#" << test_case << " " << answer << "\n";
            
         
     
     
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}