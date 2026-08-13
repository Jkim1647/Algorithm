#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
     
    cin>>T;
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int num;
        cin >> num;
         
        if(num % 2 == 1){ //홀수
            if(num == 1){
                cout << "0";
            }
            else{
                cout << "4";
                for(int i=0;i<(num-1)/2;i++){
                    cout << "8";
                }
            }
             
        }
        else{ //짝수
            for(int i=0;i<num/2;i++){
                cout << "8";
            }
        }
        cout << "\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}