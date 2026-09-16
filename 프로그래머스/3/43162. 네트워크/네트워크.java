import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        /*
        1 1 0
        1 1 0
        0 0 1
        0->1-> 다 확인 끝.
        2
        
        1 1 0
        1 1 1
        0 1 1
        0->1->2 확인 끝
        
        1 0 0 1
        0 1 0 1
        0 0 1 0
        1 1 0 1
        0->3->1-> 확인 끝
        2-> 끝.        
        */
        
        boolean check[] = new boolean[n];
        List<Integer> list = new ArrayList<>();
        Deque q = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            if(check[i] == true){
                continue;
            }
            q.add(i);
            check[i] = true;
            answer++;
            
            while(!q.isEmpty()){
                int temp = (int)q.poll();
                
                for(int j=0;j<n;j++){
                    if(computers[temp][j] == 1){
                        if(check[j] == false){
                            check[j] = true;
                            q.add(j);    
                        }
                        
                    }
                }
            }
            
            
            
        }
        
        

        
        return answer;
    }
}