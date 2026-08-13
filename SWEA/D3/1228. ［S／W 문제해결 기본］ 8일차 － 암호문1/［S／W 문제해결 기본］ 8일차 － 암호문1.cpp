#include<iostream>
#include <vector>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    T = 10;
    //cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int n;
        cin >> n;
         
        vector<int> arr(50,0);
         
        for(int i=0;i<n;i++){
            cin >> arr[i];
        }
        /*
        for(int i=0;i<n;i++){
            cout << arr[i] << " ";
        }*/
         
        int d;
        cin >> d;
        for(int i=0;i<d;i++){
            string s;
            cin >> s;
             
            if(s == "I"){
                int c,m;
                cin >> c >> m;
                 
                int move[m] = {};
                 
                for(int k=0;k<m;k++){
                    cin >> move[k];
                }
                 
                for(int j=10-m;j>=c;j--){
                    swap(arr[j],arr[j+m]);
                }
                for(int k=0;k<m;k++){
                    swap(move[k],arr[k+c]);
                }
                 
                 
            }
        }
        cout << "#" << test_case << " ";
        for(int i=0;i<10;i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        /*
        #1 449047 400905 139831 408347 512816 992679 693002 835918 768525 949227
        #2 150706 600576 565945 486128 594841 566753 244528 233616 556294 697547
        150706 600576 565945 486128 594841 566753 244528 233616 556294 697547 
...
 
        #1 449047 400905 139831 408347 512816 992679 693002 835918 768525 949227 
        */
         
 
 
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}