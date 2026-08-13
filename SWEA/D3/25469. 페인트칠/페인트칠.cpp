#include<iostream>
#include <vector>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int w,h;
         
        cin >> h >> w;
         
        vector<string> map(h);
         
        for(int i=0;i<h;i++){
            cin >> map[i];
        }
         
        int black_count = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(map[i][j] == '#'){
                    black_count++;
                }
            }
        }
        int row_count = 0;
        for(int i=0;i<h;i++){
            bool all_black = 1;
            for(int j=0;j<w;j++){
                if(map[i][j] == '.'){
                    all_black = 0;
                }
            }
            if(all_black){
                row_count++;
            }
        }
         
        int col_count = 0;
        for(int i=0;i<w;i++){
            bool all_black = 1;
            for(int j=0;j<h;j++){
                if(map[j][i] == '.'){
                    all_black = 0;
                }
            }
            if(all_black){
                col_count++;
            }
        }
         
        if(black_count == 0){
            cout << 0;
        }
        else if(black_count == w*h){
            cout << min(w,h);
        }
        else{
            cout << row_count+col_count;
        }
        cout << "\n";
         
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}