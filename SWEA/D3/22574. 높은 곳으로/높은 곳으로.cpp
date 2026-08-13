#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
 
    cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int floor,bomb;
         
        cin >> floor >> bomb;
         
 
        int check_bomb = 0;
        int cur_floor = 0;
         
        for(int i=1;i<=floor;i++){
            if(cur_floor + i == bomb){
                check_bomb = 1;
            }
            cur_floor+=i;
        }
        int answer=0;
        for(int i=1;i<=floor;i++){
            answer+=i;
        }
         
        if(check_bomb == 1){
            cout << answer-1;
        }
        else{
            cout << answer;
        }
         
        cout << "\n";
 
 
    }
    return 0;
}