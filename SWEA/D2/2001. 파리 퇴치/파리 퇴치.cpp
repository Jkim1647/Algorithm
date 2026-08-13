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
        int N,M;
         
        cin >> N >> M;
         
        vector<vector<int>> arr(N, vector<int>(N));
         
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cin >> arr[i][j];
            }
        }
         
        int ans = 0;
         
        for(int i=0;i<N-M+1;i++){
            for(int j=0;j<N-M+1;j++){
                 
                int sum=0;
                for(int k=0;k<M;k++){
                    for(int h=0;h<M;h++){
                        sum += arr[i+k][j+h];
                    }
                }
                if(ans < sum){
                    ans = sum;
                }
            }
        }
        cout << "#" << test_case << " " << ans << "\n";
  
    }
    return 0;
}