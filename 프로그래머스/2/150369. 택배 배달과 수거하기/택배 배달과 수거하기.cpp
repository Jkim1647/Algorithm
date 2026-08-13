#include <iostream>
#include <vector>
#include <queue>
using namespace std;

priority_queue<pair<int, int>> D, P; 

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    
    for (int i = 0; i < n; i++)
    {
        if (deliveries[i] > 0) D.push({ i + 1, deliveries[i] });
        if (pickups[i] > 0) P.push({ i + 1, pickups[i] });
    }
    
    while (1)
    {
        if (D.empty() && P.empty()) break;
        
        int dis = 0, cnt = cap;
        if (!D.empty()) dis = max(dis, D.top().first * 2);
        if (!P.empty()) dis = max(dis, P.top().first * 2);
        answer += dis;
        
        while (!D.empty() && cnt >= D.top().second)
        {
            cnt -= D.top().second;
            cout << "D" << ' ' << D.top().second << ' ' << D.top().first << '\n';
            D.pop();
        }
        
        cnt = cap;
        while (!P.empty() && cnt >= P.top().second)
        {
            cnt -= P.top().second;
            cout << "P" << ' ' << P.top().second << ' ' << P.top().first << '\n';
            P.pop();
        }
    }
    
    return answer;
}