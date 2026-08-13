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
        int n;
         
        cin >> n;
         
        vector<int> arrA(n+1);
        vector<int> arrB(n+1);
         
        vector<char> arrC(n+1,'0');
         
        for(int i=1;i<=n;i++){
            cin >> arrA[i];
        }
        for(int i=1;i<=n;i++){
            cin >> arrB[i];
        }
         
        int index_a = 1;
        int index_b = 1;
         
        for(int i=1;i<=n;i++){
            if(i % 2 == 1){
                 
                while(arrC[arrA[index_a]] != '0'){
                    index_a++;
                }
                arrC[arrA[index_a]] = 'A';
                 
            }
            else{
                 
                while(arrC[arrB[index_b]] != '0'){
                    index_b++;
                }
                arrC[arrB[index_b]] = 'B';
            }
        }
        for(int i=1;i<=n;i++){
            cout << arrC[i];
        }
        cout << "\n";
 
    }
    return 0;
}