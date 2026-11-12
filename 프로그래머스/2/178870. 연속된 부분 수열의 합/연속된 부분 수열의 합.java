import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int N = sequence.length;
        int result_count = Integer.MAX_VALUE;
        
        
        int s = 0;
        int e = 0;
        
        int sum = 0;
        while(e <= N-1){
            sum += sequence[e];
            
            
            while(sum > k && s <= e){
                sum -= sequence[s];
                s++;
            }
            
            int len = e-s+1;
            if(sum == k){
                if(len < result_count){
                    result_count = len;
                    answer[0] = s;
                    answer[1] = e;
                    //System.out.println(sum);
                }
            }
            e++;
        }
        
        
        //System.out.println(sum);
        
        
        return answer;
    }
    
}