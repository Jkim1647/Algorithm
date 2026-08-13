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
        int can_move;
        cin >> can_move;
         
        vector<int> arr(100);
         
        for(int i=0;i<100;i++){
            cin >> arr[i];
        }
 
        while(can_move != 0){
            can_move--;
            int min=100;
            int max = 0;
            int min_index = 0;
            int max_index = 0;
            for(int i=0;i<100;i++){
                if(max < arr[i]){
                    max = arr[i];
                    max_index = i;
                }
                if(min > arr[i]){
                    min = arr[i];
                    min_index = i;
                }
            }
            arr[min_index]++;
            arr[max_index]--;
        }
         
        int max=0;
        int min = 100;
        for(int i=0;i<100;i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }
        int answer = max-min;
        cout <<  "#" << test_case <<  " " << answer << "\n";
 
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}