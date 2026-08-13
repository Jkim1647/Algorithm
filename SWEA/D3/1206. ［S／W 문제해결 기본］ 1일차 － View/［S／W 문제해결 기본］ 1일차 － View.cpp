#include<iostream>
#include <vector>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    //cin>>T;
    T = 10;
     
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int n;
        cin >> n;
         
        vector<int> build(n);
         
        for(int i=0;i<n;i++){
            cin >> build[i];
        }
 
        int answer = 0;
        for(int i=2;i<n-2;i++){
            int view_count = build[i];
            for(int j=-2;j<=2;j++){
                 
                if(j==0) continue;
                 
                if(build[i] <=  build[i+j]){
                    view_count = 0;
                    break;
                }
                int able = build[i] - build[i+j];
                view_count = min(able,view_count);
              
            }
            answer+=view_count;
        }
        cout << "#" << test_case << " "<< answer << "\n";
 
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}