#include<iostream>
#include <algorithm>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
     
    cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        long long num1, num2, num3;
        cin >> num1 >> num2 >> num3;
         
        long long sum1 = num1*(num1+1)/2 % 998244353;
        long long sum2 = num2*(num2+1)/2 % 998244353;
        long long sum3 = num3*(num3+1)/2 % 998244353;
         
         
        long long answer = (sum1*sum2)% 998244353;
        answer = (answer*sum3)% 998244353;
        cout << answer << "\n";
         
 
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}